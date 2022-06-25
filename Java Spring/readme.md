# Stageapplicatie AON10

This application is a tool used to assign students to an internship.

## Installation

Install Docker Desktop (https://www.docker.com/products/docker-desktop/), you may need to enable virtualization.

### Backend

Have Docker Desktop running.

Open the backend folder in an IDE *(ie IntelliJ)* (You need 2 seperate instances of an IDE open, one in backend folder and the other in the frontend folder)

In the terminal type *"cd src/main/docker"* to change to the docker directory.

Next type *"docker-compose up"* to run the database.

Now you can start the application (Application class).

Wait until hibernate is finished.

### Bugfix

A common error can occur because of the StoredCredential in the tokens folder.

To solve this delete the StoredCredential and re-run the application.

Click on the link and log in with the Google account.

### Frontend

Open the frontend folder in an IDE *(ie Visual Studio Code)*. (You need 2 seperate instances of an IDE open, one in backend folder and the other in the frontend folder)

Type *"npm install"* in the terminal.
Type *"npm install vue-router"* in the terminal.

Next type *"npm run serve"* to run the frontend.

## Usage

### Mainpage

### Sort / Search

Type in the **search box** to look search for matching fields.

Sort by company, title, specialization, students, period, reviewer by clicking on any of the **headers**.

Filter by hovering over **status** and select one to filter that status.

### Backup / Recover

Click on **backup** in the header menu to make a backup of the current version.

Click on **restore** and select a file to return to that version.


### Detailspage

Click on an intership in the **main page** to see the details.

Select a student from the **student dropdownmenu** to assign a student to this internship.

Click on the **logo** or the **back arrow** to return to the mainpage.

### Edit Detailspage

Click on the **pencil** to edit contents of the internship.

Click on **save** after editing the required fields to update the internship or click on **cancel** to neglect changes.



