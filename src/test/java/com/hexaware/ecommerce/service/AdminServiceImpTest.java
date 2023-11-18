package com.hexaware.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.hexaware.ecommerce.dto.AdminDTO;
import com.hexaware.ecommerce.entities.Admin;
import com.hexaware.ecommerce.repository.AdminRepository;

class AdminServiceImpTest {

	@Mock
	private AdminRepository adminRepositoryMock;

	@Mock
	private PasswordEncoder passwordEncoderMock;

	@MockBean
	private PasswordEncoder passwordEncoder;
	@Autowired
	private AdminRepository adminRepository;
	@InjectMocks
	private AdminServiceImp adminService;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testCreateAdmin() {
		AdminDTO adminDTO = new AdminDTO();
		Admin admin = new Admin();
		admin.setAdminId(adminDTO.getAdminId());
		admin.setAdminName(adminDTO.getAdminName());
		admin.setAdminUserName(adminDTO.getAdminUserName());
		admin.setAdminPassword(adminDTO.getAdminPassword());
		admin.setAdminContact(adminDTO.getAdminContact());
		admin.setAdminEmail(adminDTO.getAdminEmail());
		admin.setRoles(adminDTO.getRoles());
		when(passwordEncoderMock.encode(adminDTO.getAdminPassword())).thenReturn("encodedPassword");
		when(adminRepositoryMock.save(any(Admin.class))).thenReturn(admin);

		Admin createdAdmin = adminService.createAdmin(adminDTO);

		verify(passwordEncoderMock).encode(adminDTO.getAdminPassword());
		verify(adminRepositoryMock).save(any(Admin.class));

		assertEquals(admin.getAdminId(), createdAdmin.getAdminId());
		assertEquals(admin.getAdminName(), createdAdmin.getAdminName());
		assertEquals(admin.getAdminUserName(), createdAdmin.getAdminUserName());
		assertEquals(admin.getAdminPassword(), createdAdmin.getAdminPassword());
		assertEquals(admin.getAdminContact(), createdAdmin.getAdminContact());
		assertEquals(admin.getAdminEmail(), createdAdmin.getAdminEmail());
		assertEquals(admin.getRoles(), createdAdmin.getRoles());

	}

	
	@Test
	void testDeleteAdmin() {

		Admin existingAdmin = new Admin();
		existingAdmin.setAdminId(existingAdmin.getAdminId());
		existingAdmin.setAdminName(existingAdmin.getAdminName());
		existingAdmin.setAdminUserName(existingAdmin.getAdminUserName());
		existingAdmin.setAdminPassword(existingAdmin.getAdminPassword());
		existingAdmin.setAdminContact(existingAdmin.getAdminEmail());
		existingAdmin.setAdminEmail(existingAdmin.getAdminEmail());

		when(adminRepositoryMock.findById(existingAdmin.getAdminId())).thenReturn(Optional.of(existingAdmin));

		adminService.deleteAdmin(existingAdmin.getAdminId());

		verify(adminRepositoryMock).findById(existingAdmin.getAdminId());
		verify(adminRepositoryMock).delete(existingAdmin);
	}

	@Test
	void testGetAdminById() {
		Admin existingAdmin = new Admin();
		existingAdmin.setAdminId(existingAdmin.getAdminId());
		existingAdmin.setAdminName(existingAdmin.getAdminName());
		existingAdmin.setAdminUserName(existingAdmin.getAdminUserName());
		existingAdmin.setAdminPassword(existingAdmin.getAdminPassword());
		existingAdmin.setAdminContact(existingAdmin.getAdminEmail());
		existingAdmin.setAdminEmail(existingAdmin.getAdminEmail());

		when(adminRepositoryMock.findById(existingAdmin.getAdminId())).thenReturn(Optional.of(existingAdmin));

		AdminDTO adminDTO = adminService.getAdminById(existingAdmin.getAdminId());

		verify(adminRepositoryMock).findById(existingAdmin.getAdminId());

		assertEquals(existingAdmin.getAdminId(), adminDTO.getAdminId());
		assertEquals(existingAdmin.getAdminName(), adminDTO.getAdminName());
		assertEquals(existingAdmin.getAdminUserName(), adminDTO.getAdminUserName());
		assertEquals(existingAdmin.getAdminPassword(), adminDTO.getAdminPassword());
		assertEquals(existingAdmin.getAdminContact(), adminDTO.getAdminContact());
		assertEquals(existingAdmin.getAdminEmail(), adminDTO.getAdminEmail());
	}

	
}
