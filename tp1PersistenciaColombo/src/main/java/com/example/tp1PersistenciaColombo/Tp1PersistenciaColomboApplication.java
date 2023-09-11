package com.example.tp1PersistenciaColombo;


import com.example.tp1PersistenciaColombo.entidades.*;
import com.example.tp1PersistenciaColombo.repositorios.*;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Tp1PersistenciaColomboApplication {

	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	DetallePedidoRepository detallePedidoRepository;
	@Autowired
	RubroRepository rubroRepository;
	@Autowired
	DomicilioRepository domicilioRepository;
	@Autowired
	ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(Tp1PersistenciaColomboApplication.class, args);

	}

	@Bean
	CommandLineRunner init(UsuarioRepository usuarioRepository,PedidoRepository pedidoRepository,DetallePedidoRepository detallePedidoRepository,RubroRepository rubroRepository,DomicilioRepository domicilioRepository,ClienteRepository clienteRepository) {
		return args -> {
			Pedido pedido1 = Pedido.builder()
					.fecha("6/0")
					.estado("iniciado")
					.horaEstimadaEntrega("12:30")
					.tipoEnvio("delivery")
					.total(2500.50)
					.build();

			Pedido pedido2 = Pedido.builder()
					.fecha("6/2")
					.estado("preparacion")
					.horaEstimadaEntrega("12:40")
					.tipoEnvio("retirada")
					.total(150.50)
					.build();

			Usuario usuario1 = Usuario.builder()
					.nombre("Maximo")
					.password("123TT")
					.rol("Administrador")
					.build();

			usuario1.agregarPedidoUsuario(pedido1);
			usuario1.agregarPedidoUsuario(pedido2);


			usuarioRepository.save(usuario1);

			Usuario usuarioRecuperado = usuarioRepository.findById(usuario1.getId()).orElse(null);


			if (usuarioRecuperado != null) {
				System.out.println("Nombre: " + usuarioRecuperado.getNombre());
				System.out.println("Contraseña: " + usuarioRecuperado.getPassword());
				System.out.println("Rol: " + usuarioRecuperado.getRol());
				usuarioRecuperado.mostrarPedidoUsuario();


			}
			System.out.println("**********PEDIDO -------- FACTURA UNO A UNO UNI**********");
			Factura factura1 = Factura.builder()
					.fecha("12/15")
					.numero(02525)
					.descuento(125.65)
					.formaPago("efectivo")
					.total(1500)
					.build();

			pedido1.setFactura(factura1);

			pedidoRepository.save(pedido1);
			pedidoRepository.save(pedido2);

			Pedido pedidoRecuperado = pedidoRepository.findById(pedido1.getId()).orElse(null);

			if (pedidoRecuperado != null) {
				System.out.println("Fecha: " + pedidoRecuperado.getFecha());
				System.out.println("Estado: " + pedidoRecuperado.getEstado());
				System.out.println("Tipo de Envio: " + pedidoRecuperado.getTipoEnvio());
				pedidoRecuperado.mostrarFactura();


			}
			System.out.println(" **** PEDIDO ------ DETALLE PEDIDO UNO A MUCHOS UNIDIRECCIONAL ****");


			DetallePedido detalle1 = DetallePedido.builder()
					.cantidad(4)
					.subtotal(1267.90)
					.build();

			DetallePedido detalle2 = DetallePedido.builder()
					.cantidad(6)
					.subtotal(1730.30)
					.build();

			pedido1.agregarDetallePedido(detalle1);
			pedido1.agregarDetallePedido(detalle2);



			pedidoRepository.save(pedido1);

			Pedido pedidoRecuperado1 = pedidoRepository.findById(pedido1.getId()).orElse(null);

			if (pedidoRecuperado1 != null) {
				pedidoRecuperado1.mostrarDetallePedido();
			}

			System.out.println("**** DETALLE PEDIDO ---- PRODUCTO MAMY TO ONE UNIDIRECCIONAL");
			Producto producto1 =  Producto.builder()
					.tipo("Manufacturado")
					.stockActual(5)
					.stockMinimo(2)
					.precioCompra(5000.2)
					.precioVenta(10000.5)
					.build();

			Producto producto2 =  Producto.builder()
					.tipo("Manufacturado")
					.stockActual(7)
					.stockMinimo(1)
					.precioCompra(3000.2)
					.precioVenta(25000.5)
					.build();

			detalle1.setProducto(producto1);
			detalle2.setProducto(producto2);


			detallePedidoRepository.save(detalle1);

			DetallePedido detallePedidoRecuperado = detallePedidoRepository.findById(detalle1.getId()).orElse(null);

			if (detallePedidoRecuperado != null) {
				pedidoRecuperado1.mostrarDetallePedido();
				detallePedidoRecuperado.mostrarPrdocuto();

			}

			System.out.println(" ****** RUBRO ---- PRODUCTO UNO A MUCHOS UNIDIRECCIONAL *******");

			Producto producto3 =  Producto.builder()
					.tipo("Manufacturado")
					.stockActual(7)
					.stockMinimo(1)
					.precioCompra(355210.2)
					.precioVenta(26300.5)
					.build();


			Rubro rubro = Rubro.builder()
					.denominacion("Cocina")
					.build();

			//rubro.agregarProducto(producto1);
			//rubro.agregarProducto(producto2);
			rubro.agregarProducto(producto3);
			rubroRepository.save(rubro);

			Rubro rubroRecuperado = rubroRepository.findById(rubro.getId()).orElse(null);

			if (rubroRecuperado != null) {
				rubroRecuperado.mostrarRubro();


			}


			System.out.println(" ****** DOMICILIO ---- PEDIDO UNO A MUCHOS UNIDIRECCIONAL *******");


			Pedido pedido3 = Pedido.builder()
					.fecha("6/0")
					.estado("iniciado")
					.horaEstimadaEntrega("12:30")
					.tipoEnvio("delivery")
					.total(2500.50)
					.build();

			Pedido pedido4 = Pedido.builder()
					.fecha("6/2")
					.estado("preparacion")
					.horaEstimadaEntrega("12:40")
					.tipoEnvio("retirada")
					.total(150.50)
					.build();

			Domicilio domicilio = Domicilio.builder()
					.calle("AV España")
					.numero("226")
					.localidad("San martin")
					.build();


domicilio.agregarPedidoDomicilio(pedido3);
domicilio.agregarPedidoDomicilio(pedido4);

			domicilioRepository.save(domicilio);

			Domicilio domicilioRecuperado = domicilioRepository.findById(domicilio.getId()).orElse(null);


			if (domicilioRecuperado != null) {
				domicilioRecuperado.mostrarPedidoCliente();
			}

			System.out.println(" ****** CLIENTE ---- PEDIDO UNO A MUCHOS UNIDIRECCIONAL *******");

			Pedido pedido5 = Pedido.builder()
					.fecha("6/0")
					.estado("iniciado")
					.horaEstimadaEntrega("12:30")
					.tipoEnvio("delivery")
					.total(2500.50)
					.build();

			Pedido pedido6 = Pedido.builder()
					.fecha("6/2")
					.estado("preparacion")
					.horaEstimadaEntrega("12:40")
					.tipoEnvio("retirada")
					.total(150.50)
					.build();

			Cliente cliente = Cliente.builder()
					.nombre("Maxi")
					.apellido("Perez")
					.telefono("2634753993")
					.email("a@gmail.com")
					.build();


			cliente.agregarPedidoCliente(pedido5);
			cliente.agregarPedidoCliente(pedido6);

			clienteRepository.save(cliente);

			Cliente clienteRecuperado = clienteRepository.findById(cliente.getId()).orElse(null);

			if (clienteRecuperado != null) {
				clienteRecuperado.mostrarPedidoCliente();
			}


			System.out.println("**** DETALLE PEDIDO ---- PRODUCTO MAMY TO ONE UNIDIRECCIONAL");
			Cliente cliente1 = Cliente.builder()
					.nombre("Maxi")
					.apellido("Perez")
					.telefono("2634753993")
					.email("a@gmail.com")
					.build();

			Cliente cliente2 = Cliente.builder()
					.nombre("Maxi")
					.apellido("Perez")
					.telefono("2634753993")
					.email("a@gmail.com")
					.build();



			domicilio.setCliente(cliente1);
			domicilio.setCliente(cliente2);

			domicilioRepository.save(domicilio);



			if (domicilioRecuperado != null) {
				System.out.println("FUNCIONA DOMICILIO MANY TO ONE CLIENTE");
			}




		};
	}


	}



