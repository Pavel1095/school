package ru.hogwarts.school.service.impl;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.FacultyService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyServiceImpl implements FacultyService {
    private final Map<Long, Faculty> faculties = new HashMap<>();

    private static long currentId = 1;

    @PostConstruct
    public void initFaculties(){
        add(new Faculty("Griffindor", "red"));
        add(new Faculty("Slytherin", "green"));
    }

    @Override
    public Faculty add(Faculty faculty) {
        faculty.setId(currentId++);
        faculties.put(faculty.getId(), faculty);
        return faculty;
    }

    @Override
    public Faculty get(Long id) {
        return faculties.get(id);
    }

    @Override
    public Faculty update(Long id, Faculty faculty) {

        Faculty facultyFromStorage = faculties.get(id);
        facultyFromStorage.setName(faculty.getName());
        facultyFromStorage.setColor(faculty.getColor());
        return facultyFromStorage;
    }

    @Override
    public Faculty delete(Long id) {
        return faculties.remove(id);
    }

    @Override
    public List<Faculty> getByColor(String color) {
        return faculties.values()
                .stream()
                .filter(it -> it.getColor().equals(color))
                .collect(Collectors.toList());
    }
}
