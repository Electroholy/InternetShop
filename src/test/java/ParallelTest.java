import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ParallelTest {
    public static void main(String[] args) throws InterruptedException {

        List <Class<?>> testClasses = List.of(AuthorizationTest.class,BasketTest.class,
                CatalogTest.class,CheckoutTest.class,
                FooterTest.class,HeaderTest.class,
                MainPageTest.class,ProductCardTest.class,
                RegistrationTest.class);

        ExecutorService executor = Executors.newFixedThreadPool(9);
        SummaryGeneratingListener listener = new SummaryGeneratingListener();

        for (Class<?> testClass : testClasses) {
            executor.submit(() -> {
                Launcher launcher = LauncherFactory.create();
                LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                        .selectors(DiscoverySelectors.selectClass(testClass))
                        .build();
                synchronized (listener) {
                    launcher.registerTestExecutionListeners(listener);
                }
                    launcher.execute(request);
            });
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.MINUTES);

        TestExecutionSummary summaryInformation = listener.getSummary();
        System.out.println("\n" + "Общее количество тестов: " + summaryInformation.getTestsFoundCount());
        System.out.println("Пройдено успешно: " + summaryInformation.getTestsSucceededCount());
        System.out.println("Провалено: " + summaryInformation.getTestsFailedCount());
        System.out.println("Пропущено: " + summaryInformation.getTestsSkippedCount() + "\n");

        System.out.println("Проваленные тесты:");
        summaryInformation.getFailures().forEach(failure -> {
            String displayName = failure.getTestIdentifier().getDisplayName();
            String message = failure.getException().getMessage();
            System.out.println("Тест: " + displayName);
            System.out.println("Сообщение об ошибке: " + message + "\n");
        });
    }
}
