package com.winz.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.winz.demo.model.Employee;
import com.winz.demo.service.IEmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;

	// Mostrar lista de empleados
	@GetMapping("/")
	public String viewHomePage(Model model) {

		model.addAttribute("listEmployees", employeeService.getAllEmployees());

		return "list_employee";

	}

	// Mostrar el formulario nuevo empleado
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {

		// Crear atributo de modelo para vincular datos de formulario
		Employee employee = new Employee();
		model.addAttribute("employee", employee);

		return "new_employee";

	}

	// Guardar empleado y retornar a la lista
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		// Guardar empleado en la base de datos
		employeeService.saveEmployee(employee);

		return "redirect:/";

	}

	// Mostrar el formulario para actualizar empleado
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

		// Obtener empleado del servicio
		Employee employee = employeeService.getEmployeeById(id);

		// Establecer empleado como un atributo de modelo para completar previamente el formulario
		model.addAttribute("employee", employee);

		return "update_employee";

	}
	
	// Eliminar el empleado por su id
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable (value = "id") long id) {
		
		// llamar al método de eliminación de empleados
		this.employeeService.deleteEmployeeById(id);
		
		return "redirect:/";
		
		
		
	}
	
	

}
