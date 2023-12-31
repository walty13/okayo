package com.example.okayo.service.impl;

import com.example.okayo.repository.LineRepository;
import com.example.okayo.service.LineService;
import com.example.okayo.entity.Line;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * This class implements the LineService interface and provides the implementation for the service methods.
 */
@Service
public class LineServiceImpl implements LineService {
    private LineRepository lineRepository; 
    
    /**
     * Constructs a new LineServiceImpl with the specified LineRepository.
     * 
     * @param lineRepository the repository used for accessing Line data
     */
    public LineServiceImpl(LineRepository lineRepository) {
        super();
        this.lineRepository = lineRepository;
    }

    @Override
    public List<Line> getAllLines() {
        return lineRepository.findAll();
    }

    @Override
    public Line getLineById(Long id) {
        return lineRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteLine(Long id) {
        lineRepository.deleteById(id);
    }

    @Override
    public List<Line> getAllLinesByRef(String ref) {
        List<Line> lines = new ArrayList<Line>();
        for(Line line : lineRepository.findAll()){
            if(line.getRef().equals(ref)){
                lines.add(line);
            }
        }
        return lines;
    }

    @Override
    public void saveOrUpdateLine(Line line) {
        lineRepository.save(line);
    }
}
