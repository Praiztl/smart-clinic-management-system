# Smart Clinic Management System – User Stories

This document outlines the key user stories for the Smart Clinic Management System. Each story follows the standard Agile template:

**As a [role], I want to [action], so that [benefit].**

Acceptance criteria are provided in  format to clearly define when a story is considered complete.

---

## 👩‍⚕️ Admin User Stories

### 1. Define Roles and Permissions
**As an admin,** I want to assign roles to users, so that only authorised users can access sensitive features.

```
Given I am logged in as an admin  
When I navigate to the user management panel  
Then I should be able to assign the role of doctor, patient, or admin to any user
```

### 2. View All Appointments
**As an admin,** I want to view all appointments across all doctors and patients, so that I can track usage and performance.

```
Given I am logged in as an admin
When I navigate to the appointments overview
Then I should see all scheduled appointments with doctor and patient details
```

### 3. Add and Manage Doctors
**As an admin,** I want to add, update, or remove doctor records, so that the system reflects our current staff.

```
Given I am logged in as an admin
When I navigate to the doctor management section
Then I should be able to create, edit, or delete doctor profiles
And I should be able to set their specialties and contact information
```

### 4. Manage Login Credentials
**As an admin,** I want to reset user passwords, so that users can regain access when they are locked out.

```
Given I am logged in as an admin
When I select a user account
Then I should be able to reset their password
And the user should receive notification of the password reset
```

---

## 👨‍⚕️ Doctor User Stories

### 1. View My Appointments
**As a doctor,** I want to see a list of all my upcoming appointments, so that I can prepare for consultations.

```
Given I am logged in as a doctor  
When I open my dashboard  
Then I should see a list of patients scheduled with me by date and time
```

### 2. View Patient Records
**As a doctor,** I want to view the medical history and prescriptions of a patient, so that I can provide better care.

```
Given I am logged in as a doctor
When I select a patient from my appointment list
Then I should see their complete medical history and previous prescriptions
```

### 3. Prescribe Medication
**As a doctor,** I want to add a prescription for a patient after a consultation, so that it's recorded and accessible to the patient.

```
Given I have completed a consultation with a patient
When I create a new prescription
Then the prescription should be saved to the patient's record
And the patient should be able to view it in their account
```

### 4. Set Availability
**As a doctor,** I want to define my available time slots, so that patients can only book when I'm free.

```
Given I am logged in as a doctor
When I access my schedule settings
Then I should be able to set my available days and time slots
And patients should only see my available times when booking
```

---

## 🧑‍💻 Patient User Stories

### 1. Book Appointment
**As a patient,** I want to book an appointment with a doctor of my choice, so that I can get medical help at my convenience.

```
Given I am logged in as a patient  
When I search for a doctor by name or specialty  
And I select a time slot and click "Book Now"  
Then I should receive a confirmation that my appointment is scheduled
```

### 2. View My Appointments
**As a patient,** I want to see all my upcoming appointments, so that I can remember my consultation dates.

```
Given I am logged in as a patient
When I navigate to my appointments section
Then I should see all my scheduled appointments with date, time, and doctor details
```

### 3. View Prescriptions
**As a patient,** I want to view the prescriptions given to me by doctors, so that I can follow treatment instructions.

```
Given I am logged in as a patient
When I access my prescriptions section
Then I should see all medications prescribed to me
And I should see dosage instructions and prescribing doctor information
```

### 4. Search for Doctors
**As a patient,** I want to search for doctors by name or specialty, so that I can find the right healthcare provider.

```
Given I am logged in as a patient
When I use the doctor search feature
Then I should be able to filter by name, specialty, or availability
And I should see relevant doctor profiles with their information
```