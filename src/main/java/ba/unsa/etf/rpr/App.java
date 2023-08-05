package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.CookManager;
import ba.unsa.etf.rpr.business.MealManager;
import ba.unsa.etf.rpr.business.StudentManager;
import ba.unsa.etf.rpr.domain.Cook;
import ba.unsa.etf.rpr.domain.Meal;
import ba.unsa.etf.rpr.domain.Student;
import ba.unsa.etf.rpr.exceptions.MyException;
import org.apache.commons.cli.*;

import java.io.PrintWriter;
import java.util.List;


public class App {
    private static final CookManager cookManager= new CookManager();
    private static final StudentManager studentManager = new StudentManager();
    private static final MealManager mealManager = new MealManager();

    private static final Option addCook = new Option("AddC","add-cook",false, "Adding new cook to database");
    private static final Option addStudent = new Option("AddS","add-student",false, "Adding new student to database");
    private static final Option addMeal = new Option("AddM", "add-meal", false, "Adding new meal to database");

    private static final Option getCooks = new Option("GetC","get-cooks",false, "Printing all cooks from database");
    private static final Option getStudents = new Option("GetS","get-students",false, "Printing all students from database");
    private static final Option getMeals = new Option("GetM", "get-meals", false, "Printing all meals from database");

    private static final Option deleteCook = new Option("deleteC","delete-cook",false,"Deletes a cook from database");
    private static final Option deleteStudent = new Option("deleteS","delete-student",false,"Deletes a student from database");
    private static final Option deleteMeal = new Option("deleteM","delete-meal",false,"Deletes a meal from database");

    public static void printFormattedOptions(Options options){
        HelpFormatter helpFormatter = new HelpFormatter();
        PrintWriter printWriter = new PrintWriter(System.out);
        helpFormatter.printUsage(printWriter, 150, "java -jar quote-maker.jar [option] 'something else if needed' ");
        helpFormatter.printOptions(printWriter, 150, options, 2, 7);
        printWriter.close();
    }
    public static Options addOptions(){
        Options options = new Options();
        options.addOption(addCook);
        options.addOption(addMeal);
        options.addOption(addStudent);
        return options;
    }
    public static Meal searchThroughMeals(List<Meal> listOfMeals, String nameOfMeal){
        Meal meal = null;
        meal = listOfMeals.stream().filter(m -> m.getName().toLowerCase().equals(nameOfMeal.toLowerCase())).findAny().get();
        return meal;
    }

    public static Cook searchThroughCooks(List<Cook> listOfCooks, String nameOfCook){
        Cook cook = null;
        cook = listOfCooks.stream().filter(c -> c.getName().toLowerCase().equals(nameOfCook.toLowerCase())).findAny().get();
        return cook;
    }

    public static void main(String[] args) throws MyException, ParseException {
        Options options = addOptions();
        CommandLineParser commandLineParser = new DefaultParser();
        CommandLine cl = commandLineParser.parse(options, args);


        if (cl.hasOption(addMeal.getOpt()) || cl.hasOption(addMeal.getLongOpt())){
            Student student = null;
            Cook cook = null;
            cook = searchThroughCooks(cookManager.getAll(), cl.getArgList().get(1));

            Meal meal = new Meal();
            meal.setTaken(Boolean.valueOf(cl.getArgList().get(2)));
            meal.setDescription(cl.getArgList().get(1));
            meal.setName(cl.getArgList().get(5));
            meal.setStudent(null);
            meal.setCook(cook);
        }
    }
}
