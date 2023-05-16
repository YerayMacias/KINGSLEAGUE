CREATE or replace TYPE equipo AS OBJECT("@posicion" NUMBER(2),
                                    NOMBRE VARCHAR2(50),
                                    victorias NUMBER(2),
                                    DERROTAS NUMBER(2));
                                    
CREATE OR REPLACE TYPE CLASIFICACION_TIPO AS OBJECT (equipos equiposlist_tipo,
                                            fecha_expiracion date
);

CREATE or replace TYPE EQUIPOSLIST_TIPO AS TABLE OF EQUIPO;

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

CREATE or replace TYPE PARTIDO AS OBJECT("@id_partido" NUMBER(2),
                                         "@id_jornada" NUMBER(2),
                                         equipo_local VARCHAR2(50),
                                         equipo_visitante VARCHAR2(50),
                                         goles_local NUMBER(2),
                                         goles_visitante NUMBER(2),
                                         tipo_partido VARCHAR2(40),
                                         hora varchar2(30));
                                         
CREATE or replace TYPE PARTIDOS_LIST AS TABLE OF PARTIDO;
                                         
CREATE OR REPLACE TYPE ULTIMA_JORNADA AS OBJECT ("@id_jornada" number(2),
                                                 "@id_temporada" number(2),
                                                 "@num_jornada" number(2),
                                                 fecha date,
                                                 partidos partidos_list,
                                                 fecha_expiracion date);

CREATE OR REPLACE FUNCTION poner_ceros(p_cadena VARCHAR2)
RETURN VARCHAR2
IS
    v_cadena VARCHAR2(12);
BEGIN
    v_cadena := p_cadena || ':00.000';
    RETURN v_cadena;
END poner_ceros;

create or replace package kings_league_xml as         
    procedure obtener_xml_clasificacion;
    procedure obtener_xml_jornadas ;
    procedure obtener_xml_ultimajornada ;
end kings_league_xml;

CREATE OR REPLACE PACKAGE BODY kings_league_xml AS

  PROCEDURE obtener_xml_clasificacion AS
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

  END obtener_xml_clasificacion;

  PROCEDURE obtener_xml_jornadas AS
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
  END obtener_xml_jornadas;


  PROCEDURE obtener_xml_ultimajornada AS
  qryCtx DBMS_XMLGEN.ctxHandle;
  v_fecha_expiracion DATE;
  result clob;
BEGIN
  qryCtx := DBMS_XMLGEN.newContext(
    'SELECT ULTIMA_JORNADA(J.ID_JORNADA, J.ID_TEMPORADA, J.NUM_JORNADA, J.FECHA,
                      CAST(MULTISET(
                      SELECT P.ID_PARTIDO, P.ID_JORNADA, EL.NOMBRE, EV.NOMBRE, PL.GOLES, PV.GOLES,P.TIPO_PARTIDO,poner_ceros(p.hora)
                      FROM PARTIDOS P, EQUIPOS EL, EQUIPOS EV, PARTIDOS_LOCALES PL, PARTIDOS_VISITANTES PV
                      WHERE  P.ID_PARTIDO = PL.ID_PARTIDO AND P.ID_PARTIDO = PV.ID_PARTIDO
                      AND EL.ID_EQUIPO = PL.ID_EQUIPO AND EV.ID_EQUIPO = PV.ID_EQUIPO
                      AND ID_JORNADA = (SELECT MAX(ID_JORNADA) FROM JORNADAS WHERE ID_TEMPORADA = (SELECT MAX(ID_TEMPORADA) FROM TEMPORADAS))
                      ORDER BY P.ID_PARTIDO) AS PARTIDOS_LIST),
                      J.FECHA + 2) AS JORNADA
                      FROM JORNADAS J
                      WHERE J.ID_JORNADA = (SELECT MAX(ID_JORNADA) FROM JORNADAS WHERE ID_TEMPORADA = (SELECT MAX(ID_TEMPORADA) FROM TEMPORADAS))
                      AND J.ID_TEMPORADA = (SELECT MAX(ID_TEMPORADA) FROM TEMPORADAS)');
  -- Set the name of the document root element. The default name is ROWSET
  DBMS_XMLGEN.setRowSetTag(qryCtx, '');
  
  -- Set the name of the row element
   DBMS_XMLGEN.setRowTag(qryCtx, '');

  -- Get the result
  result := DBMS_XMLGEN.getXML(qryCtx);
  result := REGEXP_REPLACE(result, '<PARTIDOS>', '');
  result := REGEXP_REPLACE(result, '</PARTIDOS>', '');
   --Select fecha into fecha_expiracion from jornadas where id_jornada=14;
   -- result := result  || '<fecha_expiracion>' || TO_CHAR(fecha_expiracion, 'YYYY-MM-DD') || '</fecha_expiracion>';
   SELECT FECHA + 2 INTO V_FECHA_EXPIRACION
   FROM JORNADAS 
   WHERE ID_JORNADA = (SELECT MAX(ID_JORNADA) FROM JORNADAS WHERE ID_TEMPORADA = (SELECT MAX(ID_TEMPORADA) FROM TEMPORADAS));
  -- Insert the XML result into the temporary table
  INSERT INTO TEMP_XML_ULTIMAJORNADA VALUES(result, V_FECHA_EXPIRACION);
  
  -- Close context
  DBMS_XMLGEN.closeContext(qryCtx);
  END obtener_xml_ultimajornada;
END kings_league_xml;





BEGIN
  kings_league_xml.obtener_xml_clasificacion();
END;
BEGIN
  kings_league_xml.obtener_xml_jornadas();
END;
BEGIN
  kings_league_xml.obtener_xml_ultimajornada();
END;

