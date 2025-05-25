package Set.Task;

import java.util.*;

public class SetRun {

    public static void main(String[] args) {
        Set<Task> tasks = TaskData.getTasks("all");
        sortAndPrint("All Tasks",tasks);

        Comparator<Task> sortByPriority = Comparator.comparing(Task::getPriority);
        Set<Task> annasTasks = TaskData.getTasks("Ann");
        sortAndPrint("Ann's Tasks",annasTasks,sortByPriority);
        Set<Task> BobsTasks = TaskData.getTasks("Bob");
        Set<Task> CarolsTasks = TaskData.getTasks("Carol");

        List<Set<Task>> sets = List.of(annasTasks,BobsTasks,CarolsTasks);

        Set<Task> assignedTasks = getUnion(sets);
        sortAndPrint("Assigned tasks",assignedTasks);

        Set<Task> everyTask = getUnion(List.of(tasks,assignedTasks));

        sortAndPrint("The True All Tasks", everyTask);

        Set<Task> completedTasks = getDifference(everyTask,tasks);
        sortAndPrint("Missing Tasks",completedTasks);

        Set<Task> unassignedTasks = getDifference(tasks,assignedTasks);
        sortAndPrint("Unassigned Tasks",unassignedTasks);

        Set<Task> overlapTasks = getUnion(List.of(
                getIntersection(annasTasks,BobsTasks),
                getIntersection(CarolsTasks,BobsTasks),
                getIntersection(annasTasks,CarolsTasks)
        ));

        sortAndPrint("multiples to Assignedee",overlapTasks,sortByPriority);
    }
    private static void sortAndPrint(String header, Collection<Task> collection){
        sortAndPrint(header, collection,null);
    }
    private  static  void sortAndPrint(String header, Collection<Task> tasks, Comparator<Task> comparator){
        String lineSeperator = "_".repeat(90);
        System.out.println(lineSeperator);
        System.out.println(header);
        System.out.println(lineSeperator);

        List<Task> list = new ArrayList<>(tasks);
        list.sort(comparator);
        list.forEach(System.out::println);

    }

    private static Set<Task> getUnion( List<Set<Task>> sets){
        Set<Task> union = new HashSet<>();
        for(var taskSet:sets){
            union.addAll(taskSet);
        }
        return union;
    }

    private static Set<Task> getIntersection(Set<Task> a, Set<Task> b){
        Set<Task> intersection = new HashSet<>(a);
        intersection.retainAll(b);
        return intersection;
    }

    private static Set<Task> getDifference(Set<Task>a, Set<Task>b){
        Set<Task> difference = new HashSet<>(a);
        difference.removeAll(b);
        return difference;
    }


}
