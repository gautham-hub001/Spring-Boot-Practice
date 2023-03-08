mvn install is the option that is most often used. It will only create a jar file.
mvn package is seldom used, only if you're debugging some issue with the maven build process. It will create a jar file and install the jar (and class etc.) files in the proper places if other code depends on those jars.
mvn clean install: deletes the target directory and recreates all jars in that location.

Dependencies will be stored at ~/.m2/repository. So, if you want to remove any unnecessary cache:
rm -rf ~/.m2/repository

You don't need external servers for Spring boot. You have embedded tomcat. You don't need to install tomcat seperately, you candirectly run the project.

# Error points

1. Was getting tomcat jasper errors if spring 3.x is used. So, use spring 2.x
2. Getting error if commenting and uncommenting lines in application.properties. Had to remove everything and type word-by-word to get dropdowns and used them and hten it worked. So, be careful when commenting and uncommenting code.

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

Used for REST controller classes

For working with .jsp files, you need to add a dependency: tomcat jasper(JSP Parser). Goto mvnrepository.com and search for jasper and check the version of the embedded tomcat in your project by running **mvn dependency:tree** in terminal and click on the same versdion of jasper from here and copy the dependency code for maven and paste it in your pom.xml file.

Now, spring boot can convert the jsp into servlet.

The webapp folder we're using is public. To make it private:

Create a sub folder inside webapp called as pages and move home.jsp to pages
change return "home.jsp" to "home"
Open applicaiton.properties file and here we'll mention prefix and suffix: spring.mvc.view.prefix=/pages/ spring.mvc.view.suffix=.jsp
We can also use .yaml file instead of application.properties but only in application.preoperties we can mention all the properties

Getting data from user (Dynamic page): You want to create a dynamic page which takes user name and displays it on the page. eg: localhst:8080/home?name=gautham

In your HomeController: public String home(HttpServletRequest req){ String name = req.getParameter("name"); }

To send this data to the web page, spring boot would use either RequestDispatcher or res.sendredirect
Watch Servlet videos: requestDispatcher

If you check the URL, it won't e changed even after the page gets reloaded. So, spring is using RequestDispatcher

In RequestDispatcher, 2 servlets or 1 servlet and 1 RequestDispatcher share the same req object.

1. First way:
   To send the name parameter we will do: req.setAttribute("name") and we will use req.getAttribute("name") at home.jsp
2. Second way: Using HttpSession
   We can print the name parameter using JSTl(EL language - Expression language)
   ${name}
