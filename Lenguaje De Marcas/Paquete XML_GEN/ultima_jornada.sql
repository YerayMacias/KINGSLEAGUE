DECLARE
  qryCtx DBMS_XMLGEN.ctxHandle;
  v_fecha_expiracion DATE;
  result clob;
BEGIN
  qryCtx := DBMS_XMLGEN.newContext(
    'SELECT ULTIMA_JORNADA(J.ID_JORNADA, J.ID_TEMPORADA, J.NUM_JORNADA, J.FECHA,
                      CAST(MULTISET(
                      SELECT P.ID_PARTIDO, P.ID_JORNADA, EL.NOMBRE, EV.NOMBRE, PL.GOLES, PV.GOLES
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
END;

/*SELECT ULTIMA_JORNADA(J.ID_JORNADA, J.ID_TEMPORADA, J.NUM_JORNADA, J.FECHA,
                      CAST(MULTISET(
                      SELECT P.ID_PARTIDO, P.ID_JORNADA, EL.NOMBRE, EV.NOMBRE, PL.GOLES, PV.GOLES
                      FROM PARTIDOS P, EQUIPOS EL, EQUIPOS EV, PARTIDOS_LOCALES PL, PARTIDOS_VISITANTES PV
                      WHERE  P.ID_PARTIDO = PL.ID_PARTIDO AND P.ID_PARTIDO = PV.ID_PARTIDO
                      AND EL.ID_EQUIPO = PL.ID_EQUIPO AND EV.ID_EQUIPO = PV.ID_EQUIPO
                      AND ID_JORNADA = (SELECT MAX(ID_JORNADA) FROM JORNADAS WHERE ID_TEMPORADA = (SELECT MAX(ID_TEMPORADA) FROM TEMPORADAS))
                      ORDER BY P.ID_PARTIDO) AS PARTIDOS_LIST),
                      J.FECHA + 2) AS JORNADA
FROM JORNADAS J
WHERE J.ID_JORNADA = (SELECT MAX(ID_JORNADA) FROM JORNADAS WHERE ID_TEMPORADA = (SELECT MAX(ID_TEMPORADA) FROM TEMPORADAS))
AND J.ID_TEMPORADA = (SELECT MAX(ID_TEMPORADA) FROM TEMPORADAS);*/

CREATE or replace TYPE PARTIDO AS OBJECT("@id_partido" NUMBER(2),
                                         "@id_jornada" NUMBER(2),
                                         equipo_local VARCHAR2(50),
                                         equipo_visitante VARCHAR2(50),
                                         goles_local NUMBER(2),
                                         goles_visitante NUMBER(2));
                                         
CREATE or replace TYPE PARTIDOS_LIST AS TABLE OF PARTIDO;
                                         
CREATE OR REPLACE TYPE ULTIMA_JORNADA AS OBJECT ("@id_jornada" number(2),
                                                 "@id_temporada" number(2),
                                                 "@num_jornada" number(2),
                                                 fecha date,
                                                 partidos partidos_list,
                                                 fecha_expiracion date);
drop type partido;
drop type partidos_list;
drop type ultima_jornada;

DROP TABLE TEMP_XML_ULTIMAJORNADA;

CREATE TABLE TEMP_XML_ULTIMAJORNADA(
    RESULTADO CLOB,
    FECHA_EXPIRACION DATE
);