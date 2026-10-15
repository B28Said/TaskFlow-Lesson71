

package kg.megalab.taskflow;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {

            TaskService taskService = context.getBean(TaskService.class);

            taskService.create("Изучить Java");
            taskService.create("Изучить Spring");
            taskService.create("Разобраться с Dependency Injection");

            for (Task task : taskService.findAll()) {
                System.out.println(task);
            }
        }
    }
}
