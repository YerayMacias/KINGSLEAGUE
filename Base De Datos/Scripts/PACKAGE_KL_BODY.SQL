create or replace PACKAGE BODY KL_CALENDARIO AS

    PROCEDURE GENERAR_CALENDARIO
    AS
        V_CONTADOR INTEGER;
        V_ID_EQUIPO_LOCAL EQUIPOS.ID_EQUIPO%TYPE;
        V_ID_EQUIPO_VISITANTE EQUIPOS.ID_EQUIPO%TYPE;
        V_ID_PARTIDO PARTIDOS.ID_PARTIDO%TYPE;
        V_HORA_PARTIDO VARCHAR2(5) := '16:00';
        V_FECHA_JORNADA DATE := TO_DATE('01/01/2023', 'DD/MM/YYYY');
        V_ID_JORNADA NUMBER := 1;
        V_NUM_ENFRENTADOS NUMBER;
        V_EQ1_JOR NUMBER;
        V_EQ2_JOR NUMBER;
    BEGIN
        FOR NUM_JOR IN 1..11 LOOP
            -- GENERANDO LA JORNADA
            INSERT INTO JORNADAS(ID_TEMPORADA, NUM_JORNADA, FECHA)
            VALUES (1, NUM_JOR, V_FECHA_JORNADA);
            V_FECHA_JORNADA := V_FECHA_JORNADA + 7;
        END LOOP;
        
        V_NUM_ENFRENTADOS := 6;
        FOR EQUIPO_LOCAL IN (SELECT * FROM EQUIPOS) LOOP
            FOR EQUIPO_VISITANTE IN (SELECT * FROM EQUIPOS) LOOP
                
                IF EQUIPO_LOCAL.ID_EQUIPO <> EQUIPO_VISITANTE.ID_EQUIPO THEN
                
                    SELECT NVL(COUNT(*), 0) INTO V_CONTADOR
                    FROM PARTIDOS_LOCALES PL, PARTIDOS_VISITANTES PV
                    WHERE PL.ID_EQUIPO 
                        IN (EQUIPO_LOCAL.ID_EQUIPO, EQUIPO_VISITANTE.ID_EQUIPO)
                    AND PV.ID_EQUIPO
                        IN (EQUIPO_LOCAL.ID_EQUIPO, EQUIPO_VISITANTE.ID_EQUIPO)
                    AND PL.ID_PARTIDO = PV.ID_PARTIDO;
                    
                    SELECT NVL(COUNT(*), 0) INTO V_EQ1_JOR
                    FROM PARTIDOS_LOCALES PL
                    WHERE ID_PARTIDO IN (SELECT ID_PARTIDO
                                        FROM PARTIDOS
                                        WHERE ID_JORNADA = V_ID_JORNADA)
                    AND ID_EQUIPO = EQUIPO_LOCAL.ID_EQUIPO;
                    
                    SELECT NVL(COUNT(*), 0) INTO V_EQ2_JOR
                    FROM PARTIDOS_LOCALES PL
                    WHERE ID_PARTIDO IN (SELECT ID_PARTIDO
                                        FROM PARTIDOS
                                        WHERE ID_JORNADA = V_ID_JORNADA)
                    AND ID_EQUIPO = EQUIPO_VISITANTE.ID_EQUIPO;
                    
                   

                    IF V_CONTADOR = 0 AND V_EQ1_JOR = 0 AND V_EQ2_JOR = 0 THEN
                        V_ID_EQUIPO_LOCAL := EQUIPO_LOCAL.ID_EQUIPO;
                        V_ID_EQUIPO_VISITANTE := EQUIPO_VISITANTE.ID_EQUIPO;

                        INSERT INTO PARTIDOS (TIPO_PARTIDO, HORA, ID_JORNADA) VALUES
                        ('FR', V_HORA_PARTIDO,V_ID_JORNADA);
                        
                        SELECT ID_PARTIDO INTO V_ID_PARTIDO FROM PARTIDOS WHERE ROWNUM = 1 ORDER BY ID_PARTIDO DESC;

                        INSERT INTO PARTIDOS_LOCALES(ID_EQUIPO, ID_PARTIDO) VALUES 
                        (V_ID_EQUIPO_LOCAL, V_ID_PARTIDO);

                        INSERT INTO PARTIDOS_VISITANTES(ID_EQUIPO, ID_PARTIDO) VALUES 
                        (V_ID_EQUIPO_VISITANTE, V_ID_PARTIDO);
                        V_NUM_ENFRENTADOS := V_NUM_ENFRENTADOS - 1;
                        IF V_NUM_ENFRENTADOS = 0 THEN
                            V_ID_JORNADA := V_ID_JORNADA + 1;
                            V_NUM_ENFRENTADOS := 6;
                        END IF;
                    END IF;
                END IF;
            END LOOP;
            
        END LOOP;    
    END GENERAR_CALENDARIO;

    PROCEDURE VER_ENFRENTAMIENTOS
    (C_CURSOR OUT TCURSOR)
    AS
    BEGIN
        OPEN C_CURSOR FOR
                SELECT P.ID_PARTIDO, PL.ID_EQUIPO AS LOCAL, PV.ID_EQUIPO AS VISITANTE, P.ID_JORNADA, P.HORA
                FROM PARTIDOS P, PARTIDOS_LOCALES PL, PARTIDOS_VISITANTES PV
                WHERE P.ID_PARTIDO = PL.ID_PARTIDO AND P.ID_PARTIDO = PV.ID_PARTIDO;
    END VER_ENFRENTAMIENTOS;
END KL_CALENDARIO;