package Controller;

import Model.DoctorModel;
import java.util.HashMap;
import java.util.Map;

public class DoctorController {
    private Map<String, DoctorModel> doctorMap;

    public DoctorController() {
        this.doctorMap = new HashMap<>();
    }

    public boolean addDoctor(DoctorModel doctor) throws Exception {
        if (doctorMap == null) {
            throw new Exception("Database does not exist");
        }

        if (doctor == null || doctor.getCode() == null || doctor.getName() == null ||
                doctor.getSpecialization() == null) {
            throw new Exception("Data does not exist");
        }

        if (doctorMap.containsKey(doctor.getCode())) {
            throw new Exception("Doctor code [" + doctor.getCode() + "] is duplicate");
        }

        doctorMap.put(doctor.getCode(), doctor);
        return true;
    }

    public boolean updateDoctor(DoctorModel doctor) throws Exception {
        if (doctorMap == null) {
            throw new Exception("Database does not exist");
        }

        if (doctor == null || doctor.getCode() == null || doctor.getName() == null ||
                doctor.getSpecialization() == null) {
            throw new Exception("Data does not exist");
        }

        if (!doctorMap.containsKey(doctor.getCode())) {
            throw new Exception("Doctor code doesn’t exist");
        }

        doctorMap.put(doctor.getCode(), doctor);
        return true;
    }

    public boolean deleteDoctor(DoctorModel doctor) throws Exception {
        if (doctorMap == null) {
            throw new Exception("Database does not exist");
        }

        if (doctor == null || doctor.getCode() == null) {
            throw new Exception("Data does not exist");
        }

        if (!doctorMap.containsKey(doctor.getCode())) {
            throw new Exception("Doctor code doesn’t exist");
        }

        doctorMap.remove(doctor.getCode());
        return true;
    }

    public Map<String, DoctorModel> searchDoctor(String input) throws Exception {
        if (doctorMap == null) {
            throw new Exception("Database does not exist");
        }

        Map<String, DoctorModel> result = new HashMap<>();
        for (Map.Entry<String, DoctorModel> entry : doctorMap.entrySet()) {
            DoctorModel doctor = entry.getValue();
            if (doctor.getCode().contains(input) || doctor.getName().contains(input) ||
                    doctor.getSpecialization().contains(input)) {
                result.put(entry.getKey(), doctor);
            }
        }
        return result;
    }

    public void processAddDoctor(String code, String name, String specialization, int availability) {
        try {
            DoctorModel doctor = new DoctorModel();
            doctor.setCode(code);
            doctor.setName(name);
            doctor.setSpecialization(specialization);
            doctor.setAvailability(availability);

            if (addDoctor(doctor)) {
                System.out.println("Doctor added successfully.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void processUpdateDoctor(String code, String newName, String newSpecialization, String newAvailability) {
        try {
            DoctorModel doctor = new DoctorModel();
            doctor.setCode(code);

            if (!newName.isEmpty()) {
                doctor.setName(newName);
            }

            if (!newSpecialization.isEmpty()) {
                doctor.setSpecialization(newSpecialization);
            }

            if (!newAvailability.isEmpty()) {
                doctor.setAvailability(Integer.parseInt(newAvailability));
            }

            if (updateDoctor(doctor)) {
                System.out.println("Doctor updated successfully.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void processDeleteDoctor(String code) {
        try {
            DoctorModel doctor = new DoctorModel();
            doctor.setCode(code);

            if (deleteDoctor(doctor)) {
                System.out.println("Doctor deleted successfully.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void processSearchDoctor(String searchInput) {
        try {
            Map<String, DoctorModel> searchResult = searchDoctor(searchInput);
            if (searchResult.isEmpty()) {
                System.out.println("No matching doctors found.");
            } else {
                System.out.println("Search Results:");
                System.out.println("Code\tName\t\tSpecialization\t\tAvailability");
                for (DoctorModel doctor : searchResult.values()) {
                    System.out.println(doctor);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public Map<String, DoctorModel> getAllDoctors() {
        return new HashMap<>(doctorMap);
    }

    public void clearAllDoctors() {
        doctorMap.clear();
    }
    
    public void displayAllDoctors() {
        System.out.println("List of Doctors:");
        System.out.println("Code\tName\t\tSpecialization\t\tAvailability");
        for (DoctorModel doctor : doctorMap.values()) {
            System.out.println(doctor);
        }
    }
}

