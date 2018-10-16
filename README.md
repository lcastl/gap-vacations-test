# gap-vacations-test

Best Practices
----
Find below the way to name locators, classes and methods in the framework:

|-------------------------------------Locators---------------------------------------------|
* #### Locators: Prefix (type of object(CamelLowerCase) + name identifier(CamelUpperCase))
* Type of objects: btn=Button, txt=Texbox/TextInput, chk=Checkbox, drd=DropDown, rdb=RadioButton
cta=LinkText/CallToAction, img=Images, tbl=Table, lbl=Label, frm=frame, mdl=modal
hdr=header, icn=icon, ctn=container

| Example | btnCreateEmployee, txtFirstName, lblSuccessfulMessage |
| ------ | ------ |

|-------------------------------------Classes----------------------------------------------|
* #### Class names: (First name (CamelUpperCase) + Second name and So on(CamelUpperCase))
* Page Objects = (Location/Screen) + Page

| Example | HomePage, LoginPage, CreateUsersSteps|
| ------ | ------ |

