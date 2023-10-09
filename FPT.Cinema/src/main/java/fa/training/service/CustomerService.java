package fa.training.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fa.training.DTO.CustomerDTO;
import fa.training.model.Customer;
import fa.training.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository repo;

	/**
	 * Project:FPT-Cinema
	 * Team 1
	 * @author TraNLC 
	 * Lấy tên của khách hàng dựa trên số CMND.
	 * @param cccd Số CMND của khách hàng.
	 * @return Tên của khách hàng hoặc null nếu không tìm thấy.
	 */
	public String getCustomerName(String cccd) {
		Customer customer = repo.findById(cccd).get();
		return customer != null ? customer.getCustomerName() : null;
	}

	/**
	 * Project:FPT-Cinema
	 * Team 1
	 * @author TraNLC 
	 * Lấy danh sách tất cả khách hàng.
	 * @return Danh sách khách hàng.
	 */
	public List<Customer> getAll() {
		return repo.findAll();
	}

	/**
	 * Project:FPT-Cinema
	 * Team 1
	 * @author TraNLC 
	 * Tìm khách hàng dựa trên số CMND.
	 * @param cccd Số CMND của khách hàng.
	 * @return Khách hàng tương ứng hoặc nếu không tìm thấy sẽ ném một ngoại lệ.
	 * @throws IllegalArgumentException Nếu số CMND không hợp lệ.
	 */
	public Customer findById(String cccd) {
		return repo.findById(cccd).orElseThrow(() -> new IllegalArgumentException("Invalid Customer Id: " + cccd));
	}

	/**
	 * Project:FPT-Cinema
	 * Team 1
	 * @author TraNLC 
	 * Kiểm tra sự tồn tại của khách hàng dựa trên số CMND.
	 * @param cccd Số CMND của khách hàng.
	 * @return true nếu khách hàng tồn tại, ngược lại trả về false.
	 */
	public boolean existsById(String cccd) {
		return repo.existsById(cccd);
	}

	/**
	 * Project:FPT-Cinema
	 * Team 1
	 * @author TraNLC 
	 * Lấy danh sách khách hàng phân trang.
	 * @param pageable Thông tin về phân trang.
	 * @return Danh sách khách hàng trang hiện tại.
	 */
	public Page<Customer> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}
	
	/**
	 * Project:FPT-Cinema
	 * Team 1
	 * @author TraNLC 
	 * Tìm khách hàng dựa trên số điện thoại.
	 * @param phone Số điện thoại cần tìm.
	 * @return Khách hàng tương ứng hoặc null nếu không tìm thấy.
	 */
	public Customer findByPhone(String phone) {
		return repo.findByPhone(phone);
	}
	
	/**
	 * Project:FPT-Cinema
	 * Team 1
	 * @author TraNLC 
	 * Tìm khách hàng dựa trên địa chỉ email.
	 * @param email Địa chỉ email cần tìm.
	 * @return Khách hàng tương ứng hoặc null nếu không tìm thấy.
	 */
	public Customer findByEmail(String email) {
		return repo.findByEmail(email);
	}
	

	/**
	 * Project:FPT-Cinema
	 * Team 1
	 * @author TraNLC 
	 * Lưu thông tin của một khách hàng vào cơ sở dữ liệu.
	 * @param customer Khách hàng cần lưu.
	 */
	public void save(Customer customer) {
		repo.save(customer);
	}

	/**
	 * Project:FPT-Cinema
	 * Team 1
	 * @author TraNLC 
	 * Xóa thông tin của một khách hàng dựa trên số CMND.
	 * @param cccd Số CMND của khách hàng cần xóa.
	 */
	public void deleteById(String cccd) {
		repo.deleteById(cccd);
	}
	
	/**
	 * Project:FPT-Cinema
	 * Team 1
	 * @author TraNLC 
	 * Lấy danh sách đơn đặt vé của một khách hàng trong một khoảng thời gian cụ thể.
	 * @param cccd Số CMND của khách hàng.
	 * @param startDate Ngày bắt đầu khoảng thời gian.
	 * @param endDate Ngày kết thúc khoảng thời gian.
	 * @param pageable Thông tin về phân trang.
	 * @return Danh sách đơn đặt vé phân trang.
	 */
	public Page<CustomerDTO> getRecordsForCurrentPage(String cccd, LocalDate startDate, LocalDate endDate, Pageable pageable) {
	    return repo.getRecordsForCurrentPage(cccd, startDate, endDate, pageable);
	}

	/**
	 * Project:FPT-Cinema
	 * Team 1
	 * @author TraNLC 
	 * Cập nhật thông tin của một khách hàng.
	 * @param cccd Số CMND của khách hàng.
	 * @param phone Số điện thoại mới.
	 * @param address Địa chỉ mới.
	 * @param email Địa chỉ email mới.
	 * @return Khách hàng đã được cập nhật thông tin hoặc null nếu không tìm thấy khách hàng.
	 */
	public Customer updateCustomerInfo(String cccd, String phone, String address, String email) {
        Customer customer = repo.findById(cccd).get();

        if (customer != null) {
            customer.setPhone(phone);
            customer.setAddress(address);
            customer.setEmail(email);

            return repo.save(customer);
        }
        return null;
    }
	
}
