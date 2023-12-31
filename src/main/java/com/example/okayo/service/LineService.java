package com.example.okayo.service;

import java.util.List;

import com.example.okayo.entity.Line;

/**
 * This interface represents a service for managing lines.
 */
public interface LineService {
    /**
     * Retrieves all lines.
     *
     * @return a list of all lines
     */
    List<Line> getAllLines();

    /**
     * Retrieves a line by its ID.
     *
     * @param id the ID of the line to retrieve
     * @return the line with the specified ID, or null if not found
     */
    Line getLineById(Long id);

    /**
     * Deletes a line by its ID.
     *
     * @param id the ID of the line to delete
     */
    void deleteLine(Long id);

    /**
     * Retrieves all lines with the specified reference.
     *
     * @param ref the reference to filter lines by
     * @return a list of lines with the specified reference
     */
    List<Line> getAllLinesByRef(String ref);

    /**
     * Saves or updates a line.
     *
     * @param line the line to save or update
     */
    void saveOrUpdateLine(Line line);
}
