<div id="top"></div>

<p align="center">
    <img alt="alt title" width="300px" heigth="300px" src="src/Resources/8744534.png"/>
</p>


<h2 align="center">TEP Medical Database</h2>


<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li><a href="#details">Details</a></li>
    <li><a href="#how-to-run">How to run</a></li>
    <li><a href="#images">Images</a>
    </li>
</ol>
</details>



<!-- ABOUT THE PROJECT -->

## About The Project

TEP is a desktop application made to help organise and manage basic data of a medical institute or hospital.
Made for admins, they can manage staff info, patients info, exams done, employee shifts, medicine given and more. 
They can also see statistics of the database. The application has five major segments Schedule, Patients, Staff, 
Examinations and Database Statistics which will be shown in more detail below. 

<p align="right">(<a href="#top">back to top</a>)</p>

### Built With

* [JDK-15](https://www.oracle.com/java/technologies/downloads/)
* [JavaFx](https://openjfx.io/)
* [SceneBuilder](https://gluonhq.com/products/scene-builder/)
* [MySQL](https://www.mysql.com/)

<p align="right">(<a href="#top">back to top</a>)</p>

## Details

The project is a maven structured javafx application connected with a mySQL database. Database's ER model and Attribute 
Connections can be seen in the pdf files.

<p align="right">(<a href="#top">back to top</a>)</p>

## How to run

* open XAMPP control panel and start Apache, mySQL and Tomcat
* download and put javafx library one directory out of TEP
* open TEP with any IDE (pref. IntelliJ)
* run src/HY360/Main.java

<p align="right">(<a href="#top">back to top</a>)</p>

## Images

### Login
![](readme_pics/login.png)

The first thing you'll see is the login screen that has 3 fields, your database name, the database's username
and password (default for mysql if you haven't set it up is username="root" and password=""). By pressing `Create Tables`
you generate all needed database tables. To test the database you can press the `Insert Values` button that fills
the tables with some random data.

### Schedule
![](readme_pics/schedule.png)

In this section you can manage employee shifts. The employees are referenced using their ID which can
be seen at the top table first column.

<p align="right">(<a href="#top">back to top</a>)</p>

### Patients
![](readme_pics/patients.png)

Here you can see and update patient information, the patients are referenced with their AMKA.
![](readme_pics/patient_info.png)
and also find the best doctor for each disease symptom,
sending patients to the correct doctors.
![](readme_pics/recommend_doctor1.png)

<p align="right">(<a href="#top">back to top</a>)</p>

### Staff 
#### Search Employee
![](readme_pics/search_employee.png)
#### Show All Staff
![](readme_pics/show_all_staff_members.png)

<p align="right">(<a href="#top">back to top</a>)</p>

### Examinations 
#### Diseases
![](readme_pics/diseases.png)
#### Medicines
![](readme_pics/medicines.png)
#### Procedures
![](readme_pics/procedures.png)
#### Doctor Exam Form
![](readme_pics/doctor_exam_form.png)
![](readme_pics/doctor_reexam.png)

<p align="right">(<a href="#top">back to top</a>)</p>

### Database Statistics
#### Status of Visits Today
![](readme_pics/status_of_visits_today.png)
#### Per Date Statistics
##### Number of Incidents
![](readme_pics/number_of_incidents.png)
##### Diseases Diagnosed
![](readme_pics/diseases_diagnosed.png)
##### Exams Completed
![](readme_pics/exams_completed.png)

<p align="right">(<a href="#top">back to top</a>)</p>

##### Medicines Prescribed
![](readme_pics/medicines_prescribed.png)
#### Execute direct SQL Queries to the database 
![](readme_pics/execute_queries.png)

<p align="right">(<a href="#top">back to top</a>)</p>

