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
  c_cursor TCURSOR;
BEGIN
  mostrar_clasificacion(c_cursor);
  LOOP
    FETCH c_cursor INTO equipo_nombre, victorias, derrotas;
    EXIT WHEN c_cursor%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(equipo_nombre || ' - Victorias: ' || victorias || ' - Derrotas: ' || derrotas);
  END LOOP;
  CLOSE c_cursor;
END;

/* RESULTADO:
ULTIMATE MOSTOLES - Victorias: 8 - Derrotas: 3
PORCINOS FC - Victorias: 7 - Derrotas: 4
LOS TRONCOS FC - Victorias: 7 - Derrotas: 4
KUNISPORTS - Victorias: 7 - Derrotas: 4
SAIYANS FC - Victorias: 7 - Derrotas: 4
ANIQUILADORES FC - Victorias: 6 - Derrotas: 5
XBUYER TEAM - Victorias: 6 - Derrotas: 5
1K FC - Victorias: 5 - Derrotas: 6
EL BARRIO - Victorias: 5 - Derrotas: 6
PIO FC - Victorias: 4 - Derrotas: 7
RAYO DE BARCELONA - Victorias: 3 - Derrotas: 8
JIJANTES FC - Victorias: 1 - Derrotas: 10
*/