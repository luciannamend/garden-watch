package com.lucianna.gardenapi;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(value = {"classpath:db/testDataTruncate.sql"})
public class AbstractControllerTest {
}
