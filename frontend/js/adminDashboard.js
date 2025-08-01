document.addEventListener("DOMContentLoaded", function () {
    loadDoctorCards();
  });
  
  function loadDoctorCards() {
    fetch("/api/doctors")
      .then((response) => {
        if (!response.ok) {
          throw new Error("Failed to fetch doctors");
        }
        return response.json();
      })
      .then((doctors) => {
        const container = document.getElementById("doctorCards");
        container.innerHTML = ""; // Clear previous content
  
        if (doctors.length === 0) {
          container.innerHTML = "<p>No doctors found.</p>";
          return;
        }
  
        doctors.forEach((doctor) => {
          const card = document.createElement("div");
          card.className = "doctor-card";
          card.innerHTML = `
            <h3>${doctor.fullName}</h3>
            <p><strong>Specialty:</strong> ${doctor.specialty}</p>
            <p><strong>Email:</strong> ${doctor.email}</p>
          `;
          container.appendChild(card);
        });
      })
      .catch((error) => {
        console.error("Error loading doctor cards:", error);
      });
  }
  