package com.autolink.rest;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.autolink.controller.AseguradoraController;
import com.autolink.controller.AutoController;
import com.autolink.controller.CallCenterController;
import com.autolink.controller.LoginController;
import com.autolink.controller.ProveedorController;
import com.autolink.controller.RepuestoController;
import com.autolink.controller.TallerController;
import com.autolink.controller.UsuarioController;
import com.autolink.model.Aseguradora;
import com.autolink.model.CallCenter;
import com.autolink.model.Marca;
import com.autolink.model.Modelo;
import com.autolink.model.Proveedor;
import com.autolink.model.Repuestos;
import com.autolink.model.Taller;
import com.autolink.model.TipoUsuario;
import com.autolink.model.Usuarios;
import com.autolink.request.EstadoRequest;
import com.autolink.responses.GenericResponse;
import com.autolink.responses.LoginResponse;

@RestController
@RequestMapping(value="/rest")
public class RestApi {
	
	@Autowired
	LoginController lgc;
	
	@Autowired
	UsuarioController userc;
	
	@Autowired
	TallerController tallerc;
	
	@Autowired
	AseguradoraController asec;
	
	@Autowired
	AutoController autoc;
	
	@Autowired
	ProveedorController proveedorc;
	
	@Autowired
	RepuestoController repuestoc;
	
	@Autowired
	CallCenterController callc;
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"/login"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public LoginResponse getConfiguration(@RequestParam String user, @RequestParam String pass) {
			return lgc.validate(user,pass);	
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"/login2"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getConfiguration2(@RequestParam String user, @RequestParam String pass) {
		return new ResponseEntity<>(lgc.validate(user,pass), HttpStatus.OK);	
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"/recover"}, method = RequestMethod.GET)
	public GenericResponse recoverUser(@RequestParam String user) throws MessagingException, IOException {
			return lgc.recuperarPassword(user);
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"/recover2"}, method = RequestMethod.GET)
	public ResponseEntity<?> recoverUser() throws MessagingException, IOException {
			return new ResponseEntity<>(userc.getAllUsers(), HttpStatus.OK);
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"/recover3"}, method = RequestMethod.GET)
	public BodyBuilder recoverUser2() throws MessagingException, IOException {
			return ResponseEntity.badRequest();
	}
	
	
//	----------------------- Metodos User -------------------------------------
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"usuario/all"}, method = RequestMethod.GET)
	public Iterable<Usuarios> getAllUsers() {
			return userc.getAllUsers();
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"usuarioType/all"}, method = RequestMethod.GET)
	public Iterable<TipoUsuario> getUsersByTipo() {
			return userc.getAllTipoUsuario();
	}
	
	
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"usuario/save"}, method = RequestMethod.POST)
	public Usuarios saveUser(@RequestBody Usuarios usu) {
			return userc.save(usu);
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"usuario/save2"}, method = RequestMethod.GET)
	public Usuarios saveUser() {
			return userc.save();
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"usuario/update"}, method = RequestMethod.PUT)
	public Usuarios updateUser(@RequestBody Usuarios usu) {
			return userc.update(usu);
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"usuario/getByTipo"}, method = RequestMethod.POST)
	public Iterable<Usuarios> updateUser(@RequestBody String tipoUsuario) {
			return userc.getUsuariosXTipo(tipoUsuario);
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"usuario/update2"}, method = RequestMethod.PUT)
	public Usuarios updateUser2() {
		Usuarios usu = new Usuarios();
		Date date = new Date();
		System.out.println(date.toString());
		usu.setNombre("prueba1");
		usu.setContra("prueba3");
		usu.setUsuario("prueba4");
		TipoUsuario tp = new TipoUsuario();
		tp.setId(BigDecimal.ONE);
		tp.setNombre("Admin");
		usu.setTipo(tp);
		usu.setUsuariocrea("michu2");
		usu.setFechacreacion(date);
		return userc.update(usu);
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"usuario/status"}, method = RequestMethod.POST)
	public Usuarios changeEstateUsuario(@RequestBody EstadoRequest request) {
			return userc.changeEstado(request.getNombre(), request.isEstado());
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"usuario/status2"}, method = RequestMethod.GET)
	public Usuarios changeEstateUsuario2(boolean estado) {
			return userc.changeEstado("prueba4", estado);
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"taller/all"}, method = RequestMethod.GET)
	public Iterable<Taller> getAllTalleres() {
			return tallerc.getAllTalleres();
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"taller/save"}, method = RequestMethod.POST)
	public Taller save(@RequestBody Taller taller) {
			return tallerc.save(taller);
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"taller/status"}, method = RequestMethod.POST)
	public Taller changeEstateTaller(@RequestBody EstadoRequest request) {
			return tallerc.changeEstado(request.getNombre(), request.isEstado());
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"taller/update"}, method = RequestMethod.PUT)
	public Taller updateTaller(@RequestBody Taller prov) {
			return tallerc.update(prov);
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"aseguradora/all"}, method = RequestMethod.GET)
	public Iterable<Aseguradora> getAllAseguradora() {
			return asec.getAllAseguradoraes();
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"Aseguradora/save"}, method = RequestMethod.POST)
	public Aseguradora save(@RequestBody Aseguradora aseguradora) {
			return asec.save(aseguradora);
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"aseguradora/status"}, method = RequestMethod.POST)
	public Aseguradora changeStatusAseguradora(@RequestBody EstadoRequest request) {
			return asec.changeEstado(request.getNombre(), request.isEstado());
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"aseguradora/update"}, method = RequestMethod.PUT)
	public Aseguradora updateAseguradora(@RequestBody Aseguradora prov) {
			return asec.update(prov);
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"marca/all"}, method = RequestMethod.GET)
	public Iterable<Marca> getAllMarcas() {
			return autoc.getAllMarcas();
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"marca/save"}, method = RequestMethod.POST)
	public Marca save(@RequestBody Marca marca) {
			return autoc.saveMarca(marca);
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"marca/status"}, method = RequestMethod.POST)
	public Marca changeStatusMarca(@RequestBody EstadoRequest request) {
			return autoc.changeEstadoMarca(request.getNombre(), request.isEstado());
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"modelo/all"}, method = RequestMethod.GET)
	public Iterable<Modelo> getAllModelos() {
			return autoc.getAllModelos();
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"modelo/save"}, method = RequestMethod.POST)
	public Modelo save(@RequestBody Modelo modelo) {
			return autoc.saveModelo(modelo);
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"modelo/update"}, method = RequestMethod.PUT)
	public Modelo updateModelo(@RequestBody Modelo model) {
			return autoc.updateModelo(model);
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"modelo/status"}, method = RequestMethod.POST)
	public Modelo changeStatusModelo(@RequestBody EstadoRequest request) {
			return autoc.changeEstadoModelo(request.getNombre(), request.isEstado());
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"proveedor/all"}, method = RequestMethod.GET)
	public ResponseEntity<?> getAllProveedores() {
			return ResponseEntity.ok(proveedorc.getAllproveedores());
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"proveedor/save"}, method = RequestMethod.POST)
	public ResponseEntity<?> saveProveedor(@RequestBody Proveedor prov) {
			return ResponseEntity.ok(proveedorc.save(prov));
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"proveedor/status"}, method = RequestMethod.POST)
	public ResponseEntity<?> changeStatusProveedor(@RequestBody EstadoRequest request) {
			return ResponseEntity.ok(proveedorc.changeEstado(request.getNombre(), request.isEstado()));
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"proveedor/update"}, method = RequestMethod.PUT)
	public Proveedor updateProveedor(@RequestBody Proveedor prov) {
			return proveedorc.update(prov);
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"repuesto/all"}, method = RequestMethod.GET)
	public ResponseEntity<?> getAllRepuestos() {
			return ResponseEntity.ok(repuestoc.getAllrepuestoes());
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"repuesto/save"}, method = RequestMethod.POST)
	public ResponseEntity<?> saveRepuestos(@RequestBody Repuestos prov) {
			return ResponseEntity.ok(repuestoc.save(prov));
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"repuesto/status"}, method = RequestMethod.POST)
	public ResponseEntity<?> changeStatusRepuestos(@RequestBody EstadoRequest request) {
			return ResponseEntity.ok(repuestoc.changeEstado(request.getNombre(), request.isEstado()));
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"repuesto/update"}, method = RequestMethod.PUT)
	public Repuestos updateRepuesto(@RequestBody Repuestos prov) {
			return repuestoc.update(prov);
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"callcentee/all"}, method = RequestMethod.GET)
	public ResponseEntity<?> getAllCallCenter() {
			return ResponseEntity.ok(callc.getAllCallCenteres());
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"callcenter/save"}, method = RequestMethod.POST)
	public ResponseEntity<?> saveCallCenter(@RequestBody CallCenter prov) {
			return ResponseEntity.ok(callc.save(prov));
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"callcenter/status"}, method = RequestMethod.POST)
	public ResponseEntity<?> changeStatusCallCenter(@RequestBody EstadoRequest request) {
			return ResponseEntity.ok(callc.changeEstado(request.getNombre(), request.isEstado()));
	}
	
	@CrossOrigin(origins="http://localhost:4200") 
	@RequestMapping(value = {"callcenter/update"}, method = RequestMethod.PUT)
	public CallCenter updateCallcenter(@RequestBody CallCenter call) {
			return callc.update(call);
	}
	
	
}
