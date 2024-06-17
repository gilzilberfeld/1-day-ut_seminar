package testingil.unittesting.examples.e05.mocking;

import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

class Test_with_mockito_special {

	@Test
	void cannot_drive_without_keys() {
		Driver driver = new Driver(null);
		try(MockedStatic<Driver> mockHandler = mockStatic(Driver.class)){
			when(Driver.hasKeys()).thenReturn(false);
			assertThat(driver.canDrive()).isFalse();
		}
	}

	@Test
	void AC_is_set_off_before_we_drive() {
		Car mockCar = mock(Car.class);
		Driver driver = new Driver(mockCar);

		ArgumentCaptor<AirCondition> acCaptor =
				ArgumentCaptor.forClass(AirCondition.class);

		try(MockedConstruction<AirCondition> mockHandler = mockConstruction(AirCondition.class,
				(mock,context)-> {
			when(mock.getMode()).thenReturn(ACMode.Off);
			}
		)){
			driver.drive();
		}

		verify(mockCar).setAC(acCaptor.capture());

		AirCondition ac = acCaptor.getValue();
		assertThat(ac.getMode()).isEqualTo(ACMode.Off);
	}
}
