package com.co.robinfood.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doThrow;
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
import com.co.robinfood.service.Impl.EliminarClienteServiceImpl;

@RunWith(SpringRunner.class)
public class EliminarClienteServiceImplTest {

	@InjectMocks
	private EliminarClienteServiceImpl eliminarClienteService;
	
	@Mock
	private ClienteRepository clienteRepository;
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test
	public void eliminarClienteTest() throws MicroServiceException {
		ClienteEntity clienteEntity = new ClienteEntity();
		clienteEntity.setPrimerNombre("Juan");
		clienteEntity.setSegundoNombre("Luis");
		clienteEntity.setPrimerApellido("Aguilar");
		clienteEntity.setSegundoApellido("Aguilar");
		Mockito.when(clienteRepository.findById(anyLong())).thenReturn(Optional.of(clienteEntity));
		eliminarClienteService.eliminarCliente(1l);
		
		verify(clienteRepository, times(1)).findById(anyLong());
	}
	
	@Test
	public void eliminarClienteFailTest() throws MicroServiceException {
		Long valor = null;
		exceptionRule.expect(MicroServiceException.class);
		doThrow(new RuntimeException()).when(clienteRepository).findById(valor);
		clienteRepository.deleteById(anyLong());
		eliminarClienteService.eliminarCliente(0L);
		
		verify(clienteRepository, times(1)).findById(anyLong());
	}
}
