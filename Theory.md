JUnit Test Lifecycle

@BeforeAll
Methods with @BeforeAll will execute prior to others. Usually used to setups, for instance, database creation. Must be
static

@AfterAll
Methods with @AfterAll will be executed at the very end. Usually used to cleanup purposes, for instance, database
deletion. Must be static

@BeforeEach
Methods with @BeforeEach will be executed before every @Test method. Used for setup purposes. If each test need a class
instance we can use it so we do not repeat the same code in every test

@AfterEach
Methods with @AfterEach willl be executed after each @Test method. Also used for cleanup purposes like database closing.