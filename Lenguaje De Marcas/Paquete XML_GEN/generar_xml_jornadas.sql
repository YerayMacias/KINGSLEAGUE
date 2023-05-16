DECLARE
  qryCtx DBMS_XMLGEN.ctxHandle;
  v_fecha_expiracion DATE;
  result clob;
BEGIN
 qryCtx := DBMS_XMLGEN.newContext(
  'SELECT TEMPORADA(T.FECHA_INICIO, T.FECHA_FIN, T.ESTADO, T.PERIODO,
  CAST(MULTISET(
  SELECT JORNADA(J.ID_JORNADA, J.ID_TEMPORADA, J.NUM_JORNADA,
  J.FECHA, CAST(MULTISET(
  SELECT PARTIDO(P.ID_PARTIDO, P.ID_JORNADA, EL.NOMBRE, EV.NOMBRE, PL.GOLES, PV.GOLES,P.TIPO_PARTIDO,poner_ceros(p.hora))
  FROM PARTIDOS P, EQUIPOS EL, EQUIPOS EV, PARTIDOS_LOCALES PL, PARTIDOS_VISITANTES PV
  WHERE  P.ID_PARTIDO = PL.ID_PARTIDO AND P.ID_PARTIDO = PV.ID_PARTIDO
  AND EL.ID_EQUIPO = PL.ID_EQUIPO AND EV.ID_EQUIPO = PV.ID_EQUIPO
  AND P.ID_JORNADA = J.ID_JORNADA
  ORDER BY P.ID_PARTIDO) AS PARTIDOS_LIST))
  FROM JORNADAS J ) AS JORNADAS_LIST), SYSDATE) AS TEMPORADA
  FROM TEMPORADAS T');
--( SELECT MAX(ID_TEMPORADA) FROM TEMPORADAS)
  -- Set the name of the document root element. The default name is ROWSET
  DBMS_XMLGEN.setRowSetTag(qryCtx, '');
  -- Set the name of the row element
   DBMS_XMLGEN.setRowTag(qryCtx, '');

  -- Get the result
  result := DBMS_XMLGEN.getXML(qryCtx);
  result := REGEXP_REPLACE(result, '<PARTIDOS>', '');
  result := REGEXP_REPLACE(result, '</PARTIDOS>', '');
  --result := REGEXP_REPLACE(result, '<temporada>', '');
  --result := REGEXP_REPLACE(result, '</temporada>', '');
   --Select fecha into fecha_expiracion from jornadas where id_jornada=14;
   -- result := result  || '<fecha_expiracion>' || TO_CHAR(fecha_expiracion, 'YYYY-MM-DD') || '</fecha_expiracion>';
  -- Insert the XML result into the temporary table
  INSERT INTO TEMP_XML_JORNADAS VALUES(result,SYSDATE);
  
  -- Close context
  DBMS_XMLGEN.closeContext(qryCtx);
END;


create or replace TYPE JORNADA AS OBJECT (   "@id_jornada" number(2),
                                                        "@id_temporada" number(2),
                                                        "@num_jornada" number(2),
                                                         fecha date,
                                                        partidos partidos_list);
                                                        

CREATE OR REPLACE TYPE TEMPORADA AS OBJECT(FECHA_INICIO DATE,
                                           FECHA_FIN DATE,
                                           ESTADO VARCHAR2(20),
                                           PERIODO VARCHAR2(20),
                                           JORNADAS JORNADAS_LIST,
                                           FECHA_EXPIRACION DATE);
create or replace TYPE PARTIDOS_LIST AS TABLE OF PARTIDO;
create or replace TYPE JORNADAS_LIST AS TABLE OF JORNADA;
DROP TYPE TEMPORADA;
DROP TYPE JORNADAS;
DROP TYPE JORNADAS_LIST;
DROP TYPE PARTIDOS_LIST;
