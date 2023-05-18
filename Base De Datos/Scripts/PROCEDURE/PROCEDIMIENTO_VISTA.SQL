CREATE OR REPLACE PROCEDURE mostrar_clasificacion (
    CLASIFICACION_CURSOR OUT SYS_REFCURSOR
)
IS
BEGIN
  OPEN CLASIFICACION_CURSOR FOR SELECT * FROM CLASIFICACION;
END;

DECLARE
  TYPE TCURSOR IS REF CURSOR;
  equipo_nombre equipos.nombre%TYPE;
  victorias NUMBER;
  derrotas NUMBER;
  goles_a_favor NUMBER;
  goles_en_contra NUMBER;
  diferencia_goles NUMBER;
  c_cursor TCURSOR;
BEGIN
  mostrar_clasificacion(c_cursor);
  LOOP
    FETCH c_cursor INTO equipo_nombre, victorias, derrotas, goles_a_favor, goles_en_contra, diferencia_goles;
    EXIT WHEN c_cursor%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(equipo_nombre || ' - Victorias: ' || victorias || ' - Derrotas: ' || derrotas || ' - Goles a favor: ' || 
    goles_a_favor || ' - Goles en contra: ' || goles_en_contra || ' - Diferencia goles: ' || diferencia_goles);
  END LOOP;
  CLOSE c_cursor;
END;

-- RESULTADO

/*
CREATE OR REPLACE PROCEDURE mostrar_clasificacion (
    CLASIFICACION_CURSOR OUT SYS_REFCURSOR
)
IS
BEGIN
  OPEN CLASIFICACION_CURSOR FOR SELECT * FROM CLASIFICACION;
END;

DECLARE
  TYPE TCURSOR IS REF CURSOR;
  equipo_nombre equipos.nombre%TYPE;
  victorias NUMBER;
  derrotas NUMBER;
  goles_a_favor NUMBER;
  goles_en_contra NUMBER;
  diferencia_goles NUMBER;
  c_cursor TCURSOR;
BEGIN
  mostrar_clasificacion(c_cursor);
  LOOP
    FETCH c_cursor INTO equipo_nombre, victorias, derrotas, goles_a_favor, goles_en_contra, diferencia_goles;
    EXIT WHEN c_cursor%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(equipo_nombre || ' - Victorias: ' || victorias || ' - Derrotas: ' || derrotas || ' - Goles a favor: ' || 
    goles_a_favor || ' - Goles en contra: ' || goles_en_contra || ' - Diferencia goles: ' || diferencia_goles);
  END LOOP;
  CLOSE c_cursor;
END;

*/