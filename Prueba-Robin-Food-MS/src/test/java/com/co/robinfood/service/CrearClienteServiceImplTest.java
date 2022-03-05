package com.co.robinfood.service;

import static org.mockito.ArgumentMatchers.any;
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
import com.co.robinfood.service.Impl.CrearClienteServiceImpl;

@RunWith(SpringRunner.class)
public class CrearClienteServiceImplTest {

	@InjectMocks
	private CrearClienteServiceImpl crearClienteService;
	
	@Mock
	private ClienteRepository clienteRepository;
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test()
	public void crearClienteFailTest() throws MicroServiceException {
		
		exceptionRule.expect(MicroServiceException.class);
		Mockito.when(crearClienteService.crearCliente(any(ClienteEntity.class))).thenReturn(null);
		crearClienteService.crearCliente(new ClienteEntity());
	}
	
	@Test()
	public void crearClienteSatisfactorioTest() throws MicroServiceException {
		ClienteEntity clienteEntity = new ClienteEntity();
		clienteEntity.setPrimerNombre("Juan");
		clienteEntity.setSegundoNombre("Luis");
		clienteEntity.setPrimerApellido("Aguilar");
		clienteEntity.setSegundoApellido("Aguilar");
		Mockito.when(clienteRepository.save(any(ClienteEntity.class))).thenReturn(clienteEntity);
		Mockito.when(clienteRepository.findById(anyLong())).thenReturn(Optional.of(clienteEntity));
		crearClienteService.crearCliente(clienteEntity);
		
		verify(clienteRepository, times(1)).save(any(ClienteEntity.class));
		verify(clienteRepository, times(1)).findById(anyLong());
	}

}
