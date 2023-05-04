CREATE OR REPLACE PROCEDURE obtener_datos_jugadores(
    jugadores_cursor OUT SYS_REFCURSOR
)
IS
BEGIN
    OPEN jugadores_cursor FOR
        SELECT J.NOMBRE, J.APELLIDO, J.DNI, J.POSICION, E.NOMBRE, EJ.SUELDO, EJ.CLAUSULA
        FROM JUGADORES J, EQUIPOS E, EQUIPOS_JUGADORES EJ
        WHERE J.ID_JUGADOR = EJ.ID_JUGADOR AND E.ID_EQUIPO = EJ.ID_EQUIPO;
END;

DECLARE
  jugadores_cursor SYS_REFCURSOR;
  nombre_jugador JUGADORES.NOMBRE%TYPE;
  apellido_jugador JUGADORES.APELLIDO%TYPE;
  dni_jugador JUGADORES.DNI%TYPE;
  posicion_jugador JUGADORES.POSICION%TYPE;
  nombre_equipo EQUIPOS.NOMBRE%TYPE;
  sueldo_jugador EQUIPOS_JUGADORES.SUELDO%TYPE;
  clausula_jugador EQUIPOS_JUGADORES.CLAUSULA%TYPE;
BEGIN
  obtener_datos_jugadores(jugadores_cursor);
  LOOP
    FETCH jugadores_cursor INTO nombre_jugador, apellido_jugador, dni_jugador, posicion_jugador, nombre_equipo, sueldo_jugador, clausula_jugador;
    EXIT WHEN jugadores_cursor%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE('Nombre: ' || nombre_jugador );
    DBMS_OUTPUT.PUT_LINE('Apellido: ' || apellido_jugador );
    DBMS_OUTPUT.PUT_LINE('DNI: ' || dni_jugador );
    DBMS_OUTPUT.PUT_LINE('Posición: ' || posicion_jugador );
    DBMS_OUTPUT.PUT_LINE('Equipo: ' || nombre_equipo);
    DBMS_OUTPUT.PUT_LINE('Sueldo: ' || sueldo_jugador || ' €');
    DBMS_OUTPUT.PUT_LINE('Clausula: ' || clausula_jugador || ' €');
    DBMS_OUTPUT.PUT_LINE(' ');
  END LOOP;
  CLOSE jugadores_cursor;
END;


/* RESULTADO (ESTOS DATOS SE GENERAN 120 VECES)

Nombre: ROGER
Apellido: ALBERTO
DNI: 05137433S
Posición: MC
Equipo: ANIQUILADORES FC
Sueldo: 22500000 €
Clausula: 3000000 €
 
Nombre: DANIEL
Apellido: PADORU
DNI: 21351952V
Posición: P
Equipo: ANIQUILADORES FC
Sueldo: 22500000 €
Clausula: 2000000 €

*/