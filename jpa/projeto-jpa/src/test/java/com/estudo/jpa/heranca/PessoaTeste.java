package com.estudo.jpa.heranca;

import com.estudo.jpa.EntityManagerTest;
import com.estudo.jpa.model.Funcionario;
import com.estudo.jpa.model.Motorista;
import com.estudo.jpa.model.Pessoa;
import com.estudo.jpa.model.Sexo;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PessoaTeste extends EntityManagerTest {

    @Test
    public void buscarTodos() {
        List<Pessoa> pessoas = entityManager
                .createQuery("SELECT p FROM Pessoa p", Pessoa.class)
                .getResultList();

        assertEquals(3, pessoas.size());

        List<Motorista> motoristas = entityManager
                .createQuery("SELECT m FROM Motorista m", Motorista.class)
                .getResultList();

        assertEquals(1, motoristas.size());

        List<Funcionario> funcionarios = entityManager
                .createQuery("SELECT f FROM Funcionario f", Funcionario.class)
                .getResultList();

        assertEquals(2, funcionarios.size());
    }

    @Test
    public void adicionarFuncionario() {
        String cpf = "222.333.555-11";

        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Marcela Nunes");
        funcionario.setCpf(cpf);
        funcionario.setDataNascimento(OffsetDateTime.parse("1989-12-03T00:00:00z"));
        funcionario.setMatricula("444.222.123-42");
        funcionario.setSexo(Sexo.FEMININO);

        entityManager.getTransaction().begin();
        entityManager.persist(funcionario);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Funcionario funcionarioValidacao = entityManager.find(Funcionario.class, 4L);

        assertNotNull(funcionarioValidacao);
        assertEquals(cpf, funcionarioValidacao.getCpf());
    }

    @Test
    public void adicionarMotorista() {
        String cnh = "333.555.774-23";

        Motorista motorista = new Motorista();
        motorista.setNome("Rafaela Bisbo");
        motorista.setDataNascimento(OffsetDateTime.parse("1990-04-30T00:00:00z"));
        motorista.setSexo(Sexo.OUTROS);
        motorista.setNumeroCNH(cnh);
        motorista.setCpf("123.423.523-32");

        entityManager.getTransaction().begin();
        entityManager.persist(motorista);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Motorista motoristaValidacao = entityManager.find(Motorista.class, 4L);

        assertNotNull(motoristaValidacao);
        assertEquals(cnh, motoristaValidacao.getNumeroCNH());
    }
}
