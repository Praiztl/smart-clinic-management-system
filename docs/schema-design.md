# Smart Clinic Management System – Schema Design

This document outlines the relational (MySQL) and document-based (MongoDB) schema designs for the Smart Clinic Management System.

---

## 🗄️ Relational Database (MySQL)

### 1. **Admin Table**
| Field        | Type          | Description                 |
|--------------|---------------|-----------------------------|
| id           | BIGINT (PK)   | Auto-generated unique ID    |
| username     | VARCHAR(50)   | Unique admin username       |
| password     | VARCHAR(100)  | Encrypted password          |

---

### 2. **Doctor Table**
| Field         | Type            | Description                         |
|---------------|-----------------|-------------------------------------|
| id            | BIGINT (PK)     | Unique doctor ID                    |
| full_name     | VARCHAR(100)    | Doctor's name                       |
| email         | VARCHAR(100)    | Unique email                        |
| specialty     | VARCHAR(50)     | Area of medical expertise           |
| password      | VARCHAR(100)    | Encrypted password                  |
| available_times | TEXT / JSON   | List of available time slots        |

---

### 3. **Patient Table**
| Field         | Type           | Description                         |
|---------------|----------------|-------------------------------------|
| id            | BIGINT (PK)    | Unique patient ID                   |
| full_name     | VARCHAR(100)   | Patient's name                      |
| email         | VARCHAR(100)   | Unique email                        |
| phone         | VARCHAR(20)    | Phone number                        |
| date_of_birth | DATE           | Date of birth                       |
| password      | VARCHAR(100)   | Encrypted password                  |

---

### 4. **Appointment Table**
| Field           | Type           | Description                                 |
|------------------|----------------|---------------------------------------------|
| id               | BIGINT (PK)    | Appointment ID                              |
| patient_id       | BIGINT (FK)    | References Patient(id)                      |
| doctor_id        | BIGINT (FK)    | References Doctor(id)                       |
| appointment_time | DATETIME       | Scheduled time (validated to be future)     |
| status           | VARCHAR(20)    | Status of appointment (Scheduled, Cancelled, etc.) |

---

## 🧾 Document Database (MongoDB)

### 📄 **Prescription Collection**

Each document represents a prescription linked to an appointment.

```json
{
  "_id": ObjectId,
  "appointmentId": 1024,
  "doctorId": 7,
  "patientId": 13,
  "medicines": [
    {
      "name": "Amoxicillin",
      "dosage": "500mg",
      "instructions": "Take after meals, twice daily"
    }
  ],
  "notes": "Patient recovering well",
  "issuedAt": "2024-07-29T10:15:00Z"
}
```

---

## 🔗 Relationships Overview

- One **admin** manages many doctors and patients.
- One **doctor** can have many **appointments**.
- One **patient** can have many **appointments**.
- One **appointment** can have one **prescription** (stored in MongoDB).