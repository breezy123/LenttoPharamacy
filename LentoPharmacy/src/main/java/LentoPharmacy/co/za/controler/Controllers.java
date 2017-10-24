package LentoPharmacy.co.za.controler;

import LentoPharmacy.co.za.domain.*;
import LentoPharmacy.co.za.factory.*;
import LentoPharmacy.co.za.service.Pharmacy.ImplService.*;
import LentoPharmacy.co.za.service.Pharmacy.PrescriptionService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by aubrey on 07/09/2017.
 */

@Controller
@RequestMapping(path = "/pharmacy")
public class Controllers {

    @Autowired
    private ConditionServicesImpl conditionServices;

    @Autowired
    private MedicineServiceImpl medicineService;

    @Autowired
    private PatientServiceImpl patientService;

    @Autowired
    private PatientConditionServiceImpl patientConditionService;

    @Autowired
    private PharmacistServiceImpl pharmacistService;

    @Autowired
    private PrescriptionService prescriptionService;

    @Autowired
    private PrescriptionLineServiceImpl prescriptionLineService;

    @Autowired
    private UsersServiceImpl usersService;

    @GetMapping(path ="/addCondition/{conditionName}")
    public @ResponseBody String addCondition(@PathVariable String conditionName)
    {
        Conditions conditions = ConditionFactory.buildCondition(conditionName);
        conditionServices.save(conditions);
        return new Gson().toJson(conditions);
    }

    @GetMapping(path ="/readCondition/{conditionId}")
    public @ResponseBody String readCondition(@PathVariable long conditionId)
    {
        Conditions conditions = conditionServices.findById(conditionId);
        return new Gson().toJson(conditions);
    }

    @GetMapping(path ="/updateCondition/{conditionId}/{conditionName}")
    public @ResponseBody String updateCondition(@PathVariable long conditionId,@PathVariable String conditionName)
    {
        Conditions conditions = conditionServices.findById(conditionId);

        if(conditions ==null){
            return new Gson().toJson("Record Doesn't Exisit");
        }

        Conditions conditionInsert = ConditionFactory.updateCondition(conditionId,conditionName);
        conditionServices.update(conditionInsert);
        return new Gson().toJson(conditionInsert);
    }

    @GetMapping(path ="/deleteCondition/{conditionId}")
    public @ResponseBody String deleteCondition(@PathVariable Long conditionId)
    {
        Conditions conditions = conditionServices.findById(conditionId);
        if(conditions ==null){
            System.out.println("Record does not exists");
        }
        else{
            conditionServices.delete(conditions);
            System.out.println("Record Deleted");
        }
        return new Gson().toJson(conditions);
    }
    // adding medicine controller
    @GetMapping(path ="/addMedicine/{medicineName}/{medicinePrice}/{quantity}/{details}")
    public @ResponseBody String addMedicine(@PathVariable String medicineName,
                                            @PathVariable double medicinePrice,
                                            @PathVariable int quantity,
                                            @PathVariable String details)
    {
        Medicine medicine = MedicineFactory.getMedicine(medicineName,medicinePrice,quantity,details);
        medicineService.save(medicine);
        return new Gson().toJson(medicine);
    }

    @GetMapping(path ="/readMedicine/{medicineId}")
    public @ResponseBody String readMedicine(@PathVariable long medicineId)
    {
        Medicine medicine = medicineService.findById(medicineId);
        return new Gson().toJson(medicine);
    }

    @GetMapping(path ="/updateMedicine/{medicineId}/{medicineName}/{medicinePrice}/{quantity}/{details}")
    public @ResponseBody String updateMedicine(@PathVariable long medicineId,
                                               @PathVariable String medicineName,
                                               @PathVariable double medicinePrice,
                                               @PathVariable int quantity,
                                               @PathVariable String details)
    {
        Medicine medicine = medicineService.findById(medicineId);

        if(medicine ==null){
            return new Gson().toJson("Record Doesn't Exisit");
        }
        Medicine medicineInsert = MedicineFactory.updateMedicine(medicineId,medicineName,medicinePrice,quantity,details);
        medicineService.update(medicineInsert);
        return new Gson().toJson(medicineInsert);
    }

    @GetMapping(path ="/deleteMedicine/{medicineId}")
    public @ResponseBody String deleteMedicine(@PathVariable Long medicineId)
    {
        Medicine medicine = medicineService.findById(medicineId);
        if(medicine ==null){
            System.out.println("Record does not exists");
        }
        else{
            medicineService.delete(medicine);
            System.out.println("Record Deleted");
        }
        return new Gson().toJson(medicine);
    }

    ///adding patient controller
    @GetMapping(path ="/addPatient/{patientName}/{medicalAidName}/{medicalAidNo}")
    public @ResponseBody String addPatient(@PathVariable String patientName,@PathVariable String medicalAidName,
                                           @PathVariable int medicalAidNo)
    {
        Patient patient = PatientFactory.getPatient(patientName,medicalAidName,medicalAidNo);
        patientService.save(patient);
        return new Gson().toJson(patient);
    }

    @GetMapping(path ="/readPatient/{patientId}")
    public @ResponseBody String readPatient(@PathVariable Long patientId)
    {
        Patient patient = patientService.findById(patientId);
        return new Gson().toJson(patient);
    }

    @GetMapping(path ="/updatePatient/{patientId}/{patientName}/{medicalAidName}/{medicalAidNo}")
    public @ResponseBody String updatePatient(@PathVariable long patientId,
                                              @PathVariable String patientName,
                                              @PathVariable String medicalAidName,
                                              @PathVariable int medicalAidNo)
    {
        Patient patient = patientService.findById(patientId);

        if(patient ==null){
            return new Gson().toJson("Record Doesn't Exisit");
        }
        Patient patientInsert = PatientFactory.updatePatient(patientId,patientName,medicalAidName,medicalAidNo);
        patientService.update(patientInsert);
        return new Gson().toJson(patientInsert);
    }

    @GetMapping(path ="/deletePatient/{medicineId}")
    public @ResponseBody String deletePatient(@PathVariable long medicineId)
    {
        Patient patient = patientService.findById(medicineId);
        if(patient ==null){
            System.out.println("Record does not exists");
        }
        else{
            patientService.delete(patient);
            System.out.println("Record Deleted");
        }
        return new Gson().toJson(patient);
    }

    @GetMapping(path ="/addPatientCondition/{patientId}/{conditionId}/{dateDiagnose}")
    public @ResponseBody String addPatientCondition(@PathVariable long patientId,
                                                    @PathVariable long conditionId,
                                                    @PathVariable String dateDiagnose)
    {
        //dateDiagnose = new Date();
        PatientCondition patientCondition = PatientConditionFactory.getPatientCondition(patientId,conditionId,dateDiagnose);
        patientConditionService.save(patientCondition);
        return new Gson().toJson(patientCondition);
    }

    @GetMapping(path ="/readPatientCondition/{patientId}")
    public @ResponseBody String readPatientCondition(@PathVariable Long patientConditionId)
    {
        PatientCondition patientCondition = patientConditionService.findById(patientConditionId);
        return new Gson().toJson(patientCondition);
    }

    @GetMapping(path ="/updatePatientCondition/{patientId}/{conditionId}/{dateDaignosed}")
    public @ResponseBody String updatePatientCondition(@PathVariable Long patientId,
                                              @PathVariable long conditionId,
                                              @PathVariable String diagnoseDate)
    {
        PatientCondition patientCondition = patientConditionService.findById(patientId);

        if(patientCondition ==null){
            return new Gson().toJson("Record Doesn't Exisit");
        }
        PatientCondition patientConditionInsert = PatientConditionFactory.getPatientCondition(patientId,conditionId,diagnoseDate);
        patientConditionService.update(patientConditionInsert);
        return new Gson().toJson(patientConditionInsert);
    }

    @GetMapping(path ="/deletePatientCondition/{patientId}")
    public @ResponseBody String deletePatientCondition(@PathVariable Long patientConditionId)
        {
        PatientCondition patientCondition = patientConditionService.findById(patientConditionId);
        if(patientCondition ==null){
            System.out.println("Record does not exists");
        }
        else{
            patientConditionService.delete(patientCondition);
            System.out.println("Record Deleted");
        }
        return new Gson().toJson(patientCondition);
    }

    // adding pharmacist controller
    @GetMapping(path ="/addPharmacy/{pharmacyName}/{qualification}")
    public @ResponseBody String addPharmacy(@PathVariable String pharmacyName,
                                                          String qualification)
    {
        Pharmacist pharmacist = PharmacistFactory.getPharmacist(pharmacyName,qualification);
        pharmacistService.save(pharmacist);
        return new Gson().toJson(pharmacist);
    }
    @GetMapping(path ="/readPharmacy/{pharmacyId}")
    public @ResponseBody String readPharmacy(@PathVariable Long pharmacyId)
    {
        Pharmacist pharmacist = pharmacistService.findById(pharmacyId);
        return new Gson().toJson(pharmacist);
    }

    @GetMapping(path ="/updatePharmacy/{pharmacyId}/{pharmacyName}/{qualification}")
    public @ResponseBody String updatePharmacy(@PathVariable long pharmacyId,
                                                       @PathVariable String pharmacyName,
                                                       @PathVariable String qualification)
    {
        Pharmacist pharmacist = pharmacistService.findById(pharmacyId);

        if(pharmacist ==null){
            return new Gson().toJson("Record Doesn't Exisit");
        }
        Pharmacist pharmacistInsert = PharmacistFactory.updatePharmacy(pharmacyId,pharmacyName,qualification);
        pharmacistService.update(pharmacistInsert);
        return new Gson().toJson(pharmacistInsert);
    }

    @GetMapping(path ="/deletePharmacy/{pharmacyId}")
    public @ResponseBody String deletePharmacy(@PathVariable Long pharmacyId)
    {
        Pharmacist pharmacist = pharmacistService.findById(pharmacyId);
        if(pharmacist ==null){
            System.out.println("Record does not exists");
        }
        else{
            pharmacistService.delete(pharmacist);
            System.out.println("Record Deleted");
        }
        return new Gson().toJson(pharmacist);
    }

    @GetMapping(path ="/addPrescription/{prescriptionDate}/{doctorId}/{patientId}/{pharmacyId}")
    public @ResponseBody String addPrescription(@PathVariable String prescriptionDate,
                                                @PathVariable long patientId,
                                                @PathVariable long pharmacyId,
                                                @PathVariable String doctorId)
    {
        Prescription prescription = PrescriptionFactory.getPrecscription(prescriptionDate,doctorId,patientId,pharmacyId);
        prescriptionService.save(prescription);
        return new Gson().toJson(prescription);
    }
    @GetMapping(path ="/readPrescription/{pharmacyId}")
    public @ResponseBody String readPrescription(@PathVariable Long prescriptionId)
    {
        Prescription prescription = prescriptionService.findById(prescriptionId);
        return new Gson().toJson(prescription);
    }
    @GetMapping(path ="/updatePrescription/{prescriptionId}/{prescriptionDate}/{doctorId}/{patientId}/{pharmacyId}")
    public @ResponseBody String updatePrescription(@PathVariable Long prescriptionId,
                                               @PathVariable String prescriptionDate,
                                               @PathVariable String doctorId,
                                                   @PathVariable long patientId,
                                                   @PathVariable long pharmacyId)
    {
        Prescription prescription = prescriptionService.findById(patientId);

        if(prescription ==null){
            return new Gson().toJson("Record Doesn't Exisit");
        }
        Prescription prescriptionInsert = PrescriptionFactory.getPrecscription(prescriptionDate,doctorId,patientId,pharmacyId);
        prescriptionService.update(prescriptionInsert);
        return new Gson().toJson(prescriptionInsert);
    }

    @GetMapping(path ="/deletePrescription/{prescriptionId}")
    public @ResponseBody String deletePrescription(@PathVariable Long prescriptionId)
    {
        Prescription prescription = prescriptionService.findById(prescriptionId);
        if(prescription ==null){
            System.out.println("Record does not exists");
        }
        else{
            prescriptionService.delete(prescription);
            System.out.println("Record Deleted");
        }
        return new Gson().toJson(prescription);
    }

    @GetMapping(path ="/addPrescriptionLine/{lineId}/{prescriptionID}/{instructions}/{medicineID}/{price}")
    public @ResponseBody String addPrescriptionLine(@PathVariable Long lineId, @PathVariable long prescriptionID,
                                                    @PathVariable String instructions, @PathVariable long medicineID,
                                                    @PathVariable double price, @PathVariable int quantity)
    {
        Prescriptionline prescriptionline = PrescriptionLineFactory.getPrescriptionLine(prescriptionID,instructions,medicineID,price,quantity);
        prescriptionLineService.save(prescriptionline);
        return new Gson().toJson(prescriptionline);
    }
    @GetMapping(path ="/readPrescriptionLine/{prescriptionLineId}")
    public @ResponseBody String readPrescriptionLine(@PathVariable Long prescriptionLineId)
    {
        Prescriptionline prescriptionline = prescriptionLineService.findById(prescriptionLineId);
        return new Gson().toJson(prescriptionline);
    }
    @GetMapping(path ="/updatePrescriptionLine/{prescriptionId}/{prescriptionDate}/{doctorId}/{patientId}/{pharmacyId}")
    public @ResponseBody String updatePrescriptionLine(@PathVariable Long lineId, @PathVariable long prescriptionID,
                                                       @PathVariable String instructions, @PathVariable long medicineID,
                                                       @PathVariable double price, @PathVariable int quantity)
    {
        Prescriptionline prescriptionline = prescriptionLineService.findById(lineId);

        if(prescriptionline ==null){
            return new Gson().toJson("Record Doesn't Exisit");
        }
        Prescriptionline prescriptionLineInsert = PrescriptionLineFactory.getPrescriptionLine(prescriptionID, instructions,medicineID,price,quantity);
        prescriptionLineService.update(prescriptionLineInsert);
        return new Gson().toJson(prescriptionLineInsert);
    }

    @GetMapping(path ="/deletePrescriptionLine/{prescriptionlineId}")
    public @ResponseBody String deletePrescriptionLine(@PathVariable Long prescriptionlineId)
    {
        Prescriptionline prescriptionline = prescriptionLineService.findById(prescriptionlineId);
        if(prescriptionline ==null){
            System.out.println("Record does not exists");
        }
        else{
            prescriptionLineService.delete(prescriptionline);
            System.out.println("Record Deleted");
        }
        return new Gson().toJson(prescriptionline);
    }
}
