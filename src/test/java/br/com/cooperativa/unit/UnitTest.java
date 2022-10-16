package br.com.cooperativa.unit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class UnitTest {

    @BeforeAll
    static void init() {
        System.out.println("Aqui estão as configurações necessárias para os testes unitários!");
    }

}
