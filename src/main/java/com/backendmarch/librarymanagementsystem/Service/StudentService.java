package com.backendmarch.librarymanagementsystem.Service;

import com.backendmarch.librarymanagementsystem.DTO.StudentRequestDto;
import com.backendmarch.librarymanagementsystem.DTO.StudentResponseDto;
import com.backendmarch.librarymanagementsystem.DTO.StudentUpdateEmailRequestDto;
import com.backendmarch.librarymanagementsystem.Entity.LibraryCard;
import com.backendmarch.librarymanagementsystem.Entity.Student;
import com.backendmarch.librarymanagementsystem.Enum.CardStatus;
import com.backendmarch.librarymanagementsystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public void addStudent(StudentRequestDto studentRequestDto){

        // create student object .
        Student student = new Student();
        student.setAge(studentRequestDto.getAge());
        student.setName(studentRequestDto.getName());
        student.setDepartment(studentRequestDto.getDepartment());
        student.setEmail(studentRequestDto.getEmail());

        //create a card object
        LibraryCard card= new LibraryCard();
        card.setStatus(CardStatus.ACTIVATED);
        card.setStudent(student);


        //set card in student
        student.setCard(card);

        //check
        studentRepository.save(student); //it will save both student and card.


    }

    public String findByEmail(String email){
        Student student=studentRepository.findByEmail((email));
        return student.getName();
    }
    public StudentResponseDto updateEmail(StudentUpdateEmailRequestDto studentUpdateEmailRequestDto){
        Student student = studentRepository.findById(studentUpdateEmailRequestDto.getId()).get();
        student.setEmail(studentUpdateEmailRequestDto.getEmail());


        // update step

        Student updatedStudent = studentRepository.save(student);

        // convert updated student to response dto

        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setId(updatedStudent.getId());
        studentResponseDto.setName(updatedStudent.getName());
        studentResponseDto.setEmail(updatedStudent.getEmail());

        return studentResponseDto;

    }

}
