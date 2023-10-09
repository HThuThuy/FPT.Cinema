package fa.training.response;

import java.util.List;

import fa.training.model.Theater;

public class TicketResponse {
	private List<Theater> cityList;

	public TicketResponse() {
	}

	public TicketResponse(List<Theater> cityList) {
		this.cityList = cityList;
	}

	public List<Theater> getCityList() {
		return cityList;
	}

	public void setCityList(List<Theater> cityList) {
		this.cityList = cityList;
	}

}
