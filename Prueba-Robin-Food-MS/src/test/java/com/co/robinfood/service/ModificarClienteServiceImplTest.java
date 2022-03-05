package com.co.robinfood.service;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.co.robinfood.exception.MicroServiceException;
import com.co.robinfood.model.ClienteEntity;
import com.co.robinfood.repository.ClienteRepository;
import com.co.robinfood.service.Impl.ModificarClienteServiceImpl;

@RunWith(SpringRunner.class)
public class ModificarClienteServiceImplTest {

	@InjectMocks
	private ModificarClienteServiceImpl modificarClienteService;
	
	@Mock
	private ClienteRepository clienteRepository;
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test()
	public void guardarEncuestaFailTest() throws MicroServiceException {
		ClienteEntity cliente = new ClienteEntity();
		cliente.setPrimerNombre("Juan");
		cliente.setSegundoNombre("Luis");
		cliente.setPrimerApellido("Aguilar");
		cliente.setSegundoApellido("Aguilar");
		modificarClienteService.modificarCliente(2L, cliente);
		
	}
	
	@Test
	public void guardarEncuestaTest() throws MicroServiceException {
		ClienteEntity cliente = new ClienteEntity();
		cliente.setPrimerNombre("Juan");
		cliente.setSegundoNombre("Luis");
		cliente.setPrimerApellido("Aguilar");
		cliente.setSegundoApellido("Aguilar");
		Mockito.when(clienteRepository.findById(anyLong())).thenReturn(Optional.of(cliente));
		modificarClienteService.modificarCliente(2L, cliente);
		
		verify(clienteRepository, times(1));

	}
}
