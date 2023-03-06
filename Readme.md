You don't need external servers for Spring boot. You have embedded tomcat. You don't need to install tomcat seperately, you candirectly run the project.

## @Component

Normal object insantiation:
Alien a = new Alien();
But this is tight coupling. So, we ask spring boot to take care of this and we get the object whenever we want using getBean()

If you want spring to create an object of class Alien, then you add @Component above the class Alien

Whenever SpringApplication.run(MyDemoApplication.class, args); gets run it creates a spring container and create object alien(default name of the object created is in lowercase) of type Alien.class.

**Note:** You can change the name of the object being created in the spring container by passing the name:
@Component("my-alien")

You can get this alien object using getBean(Alien.class);

## @Scope

For Web apps, it is of two types: request, session.
For Core apps, it is of two types: singleton, prototype
By default it is singleton.

For singleton classes, exactly object will be created right when the application starts even if you ask for it or not. Even if you ask for it multiple times using getBean(), it will return you the same object.

For prototype classes, objects will only be created whenever they're requested using getBean() and also new object will be created each time when getBean() is called.

# @Autowired

If Alien Object needs some other object (Laptop). Since this is not main class where we can easily use getBean(), we can use @Autowired and spring searches in the spring container and returns the Laptop object.

By default, it searches by type (class type)

# @Qualifier

If you want to search an object in the spring container by its name, you can use @Qualifier("name")

By default, it searches by name (name of the component)

# Creating a basic web app using jsp

localhost:8080/home -> this is a request
According to MVC,
This will call a controller, let's say HomeController.java
This controller needs to return home.jsp

This home.jsp is stored in webapp folder - this folder name is by convention in spring boot. It is going to search the file name returned by controller (as a String) in webapp folder only.

# @Controller

Used for controller classes

## @RequestMapping("home")

Used for mentioning which method to be invoked when /home gets called

## @ResponseBody

Used along with @RequestMapping
If we're returning special files like .jsp in the Controller, we need to use this tag since spring boot doesnot implicitly support .jsp. And we also need to add a dependency for

It will inform spring boot that you're not returning a String, you're returning data.

# @RestController ?

For REST controller classes
