DECLARE
  qryCtx DBMS_XMLGEN.ctxHandle;
    v_fecha_expiracion DATE;
  result clob;
BEGIN
  qryCtx := DBMS_XMLGEN.newContext(
    'SELECT clasificacion_tipo(CAST(MULTISET
            (SELECT EQUIPO(ROWNUM, C.EQUIPO, C.VICTORIAS, C.DERROTAS) as EQUIPO FROM CLASIFICACION C)
            AS EQUIPOSLIST_TIPO),
            SYSDATE) as clasificacion
    FROM DUAL');
  -- Set the name of the document root element. The default name is ROWSET
  DBMS_XMLGEN.setRowSetTag(qryCtx, '');
  
  -- Set the name of the row element
   DBMS_XMLGEN.setRowTag(qryCtx, '');

  -- Get the result
  result := DBMS_XMLGEN.getXML(qryCtx);
  result := REGEXP_REPLACE(result, '<EQUIPOS>', '');
  result := REGEXP_REPLACE(result, '</EQUIPOS>', '');
   --Select fecha into fecha_expiracion from jornadas where id_jornada=14;
   -- result := result  || '<fecha_expiracion>' || TO_CHAR(fecha_expiracion, 'YYYY-MM-DD') || '</fecha_expiracion>';
      SELECT SYSDATE + 2 INTO V_FECHA_EXPIRACION
   FROM DUAL; 
  -- Insert the XML result into the temporary table
  INSERT INTO TEMP_XML_CLASIFICACION VALUES(result,V_FECHA_EXPIRACION);
  
  -- Close context
  DBMS_XMLGEN.closeContext(qryCtx);
END;

CREATE or replace TYPE equipo AS OBJECT("@posicion" NUMBER(2),
                                    NOMBRE VARCHAR2(50),
                                    victorias NUMBER(2),
                                    DERROTAS NUMBER(2));
                                    
CREATE OR REPLACE TYPE CLASIFICACION_TIPO AS OBJECT (equipos equiposlist_tipo,
                                            fecha_expiracion date
);

CREATE or replace TYPE EQUIPOSLIST_TIPO AS TABLE OF EQUIPO;

drop type equiposlist_tipo;
drop type clasificacion_tipo;
drop type equipo_tipo;