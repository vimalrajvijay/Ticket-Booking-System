package com.example.ticket_booking_system.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ticket_booking_system.entity.Show;

public interface ShowRepository extends JpaRepository<Show, Long> {

    @Query("""
            SELECT COUNT(s) > 0
            FROM Show s
            WHERE s.screen.id = :screenId
            AND s.showDate = :showDate
            AND s.startTime < :endTime
            AND s.endTime > :startTime
            """)
    boolean existsOverlappingShow(
            @Param("screenId") Long screenId,
            @Param("showDate") LocalDate showDate,
            @Param("startTime") LocalTime startTime,
            @Param("endTime") LocalTime endTime
    );

    @Query("""
             SELECT s
             FROM Show s
             JOIN s.screen sc
             JOIN sc.theatre t
             WHERE (:movieId IS NULL OR s.movie.id = :movieId)
             AND (:theatreId IS NULL OR t.id = :theatreId)
             AND (:showDate IS NULL OR s.showDate = :showDate)
            """)
    List<Show> findShowsByFilters(
            @Param("movieId") Long movieId,
            @Param("theatreId") Long theatreId,
            @Param("showDate") LocalDate showDate
    );
}
