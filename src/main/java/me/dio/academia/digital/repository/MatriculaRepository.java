package me.dio.academia.digital.repository;

import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
    @Query(value = "SELECT * FROM tb_matriculas m " +
            "INNER JOIN tb_alunos a ON m.aluno_id = a.id " +
            "WHERE a.bairro = :bairro", nativeQuery = true)

    List<Matricula> findAlunosMatriculadosBairro(String bairro);

}
