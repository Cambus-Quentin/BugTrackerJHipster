package com.mycompany.bugtracer;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.mycompany.bugtracer");

        noClasses()
            .that()
            .resideInAnyPackage("com.mycompany.bugtracer.service..")
            .or()
            .resideInAnyPackage("com.mycompany.bugtracer.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..com.mycompany.bugtracer.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
