document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("filterDate").addEventListener("change", filterPatientsByDate);
    loadAppointments();
  });
  
  let allAppointments = [];
  
  function loadAppointments() {
    fetch("/api/appointments/doctor") // Replace with real endpoint
      .then((res) => res.json())
      .then((data) => {
        allAppointments = data;
        renderAppointments(allAppointments);
      })
      .catch((err) => console.error("Error loading appointments", err));
  }
  
  function renderAppointments(appointments) {
    const tbody = document.getElementById("patientTableBody");
    tbody.innerHTML = "";
  
    if (appointments.length === 0) {
      tbody.innerHTML = "<tr><td colspan='3'>No appointments found.</td></tr>";
      return;
    }
  
    appointments.forEach((appt) => {
      const tr = document.createElement("tr");
      tr.innerHTML = `
        <td>${appt.patientName}</td>
        <td>${new Date(appt.appointmentTime).toLocaleString()}</td>
        <td>${appt.status}</td>
      `;
      tbody.appendChild(tr);
    });
  }
  
  function filterPatientsByDate() {
    const selectedDate = document.getElementById("filterDate").value;
    const filtered = allAppointments.filter((appt) => {
      return new Date(appt.appointmentTime).toISOString().startsWith(selectedDate);
    });
    renderAppointments(filtered);
  }
  