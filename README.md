API:

Entities relationship
Category 1 ---< News >--- 1 User

--- NEWS ---
    
    Entity:

    Long id - Primary Key,
    String title,
    String content,
    User user - Foreign Key (ManyToOne),
    Category category - Foreign Key (ManyToOne),
    LocalDateTime createdAt

    Service:

    newsRepository,
    categoryRepository,
    userRepository,

        methods:

        getAll() -> return newsRepository.findAll()
        save() -> return savedNews // подгрузка данных [category, user] для POST
        delete() -> deleteById(id)
    
    Controller:

    RequestMapping "/api/news"
        ->newsService
            getAll()
            create(@RequestBody news) -> return saved news
            delete(@PathVariable("id"))

--- CATEGORY ---
    
    Entity:

    Long id - Primary Key,
    String name
    newsList (OneToMany)

    Service:

    categoryRepository,

        methods:

        getAll() -> return categoryRepository.findAll();
        save() -> return categoryRepository.save(category);
        delete() -> deleteById(id)
    
    Controller:

    RequestMapping "/api/categories"
        ->categoryService
            getAll()
            create(@RequestBody category) -> return saved category
            delete(@PathVariable("id"))

--- USER ---

    Entity:

    Long id - Primary Key,
    String username,
    String email,
    newsList (OneToMany)

    Service:

    userRepository

        methods:

        getAll() -> return userRepository.findAll();
        save() -> return userRepository.save(user);
        delete() -> deleteById(id)
    
    Controller:

    RequestMapping "/api/users"
        ->categoryService
            getAll()
            create(@RequestBody user) -> return saved user
            delete(@PathVariable("id"))

