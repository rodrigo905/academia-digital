package me.dio.academia.digital.repository;

import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

    @Query(value = "SELECT * FROM tb_matriculas m " +
            "INNER JOIN tb_alunos a ON m.aluno_id = a.id " +
            "WHERE a.bairro = :bairro", nativeQuery = true) // terceiro metodo usando native Query

    //@Query("FROM Matricula m WHERE m.aluno.bairro = :bairro ") // segundo metodo
    List<Matricula> findAlunosMatriculados(String bairro);

    // List<Matricula> findByAlunoBairro(String bairro); // primeiro metodo
    // mudar o método em getAll dentro de MatriculaServiceImpl
}
