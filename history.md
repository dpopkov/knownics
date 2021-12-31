History of implementation
-------------------------

##### 2021-12-31
* Add annotations to domain entities and embedded components. Closes #16.
* Load questions in DataLoader.
##### 2021-12-29
* Add i18n for web. Closes #14. 
* Refactor to Lombok. Closes #15. 
##### 2021-12-28
* Add module repository-jpa. Closes #11.
* Add Profiles. Closes #12.
* Add data.sql to populate database in repository-jpa profile.
* Add findByDescription to CategoryRepository, add Integration Test for CategoryJpaRepository.
* Configure Maven Failsafe plugin for Integration Tests. Closes #13.
##### 2021-12-26
* Add module services. Add CategoryService, CategoryServiceImpl.
* Implement equals and hashCode for entities. Closes #9.
* Load bootstrap data on startup. Closes #10. 
* Add controller and page for Categories.  
##### 2021-12-25
* Add module repository-map. Implement Map based repositories. Closes #5.
##### 2021-12-10
* Add Repository interfaces to Domain. Closes #7.
* Add Maven Release Plugin. Closes #4.
##### 2021-12-07
* Implement POJO data model. Closes #2.
##### 2021-12-05
* Create Multi-Module Project for Domain module. Closes #3.
##### 2021-12-02
* Initialize Spring Boot app. Closes #1.
