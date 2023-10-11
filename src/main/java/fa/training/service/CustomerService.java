/**
 * CustomerController
 *
 * Version 1.0
 *
 * Date: 09-10-2023
 *
 * Copyright
 * 
 * Modification Logs:
 * DATE                 AUTHOR            DESCRIPTION
 * -----------------------------------------------------------------------
 * 09-10-2023           TraNLC            Chứa các hàm xử lý logic nghiệp vụ liên quan đến đối tượng Customer
 */
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
     * Lấy tên của khách hàng theo id.
     * @param cccd Id của khách hàng.
     * @return Tên của khách hàng.
     */
    public String getCustomerName(String cccd) {
        Customer customer = repo.findById(cccd).get();
        return customer != null ? customer.getCustomerName() : null;
    }

    /**
     * Lấy danh sách tất cả khách hàng.
     * @return Danh sách tất cả khách hàng.
     */
    public List<Customer> getAll() {
        return repo.findAll();
    }

    /**
     * Tìm kiếm khách hàng theo id.
     * @param cccd Id của khách hàng.
     * @return Đối tượng Customer tìm thấy. Nếu không tìm thấy, ném lỗi IllegalArgumentException.
     */
    public Customer findById(String cccd) {
        return repo.findById(cccd).orElseThrow(() -> new IllegalArgumentException("Invalid Customer Id: " + cccd));
    }
    
    public Customer findByCccd(String cccd) {
        return repo.findByCccd(cccd);
    }

    /**
     * Kiểm tra sự tồn tại của khách hàng theo id.
     * @param cccd Id của khách hàng.
     * @return true nếu khách hàng tồn tại, false nếu không.
     */
    public boolean existsById(String cccd) {
        return repo.existsById(cccd);
    }

    /**
     * Lấy danh sách tất cả khách hàng theo trang.
     * @param pageable Đối tượng Pageable chứa thông tin về số trang và số lượng bản ghi trên một trang.
     * @return Một trang chứa danh sách khách hàng.
     */
    public Page<Customer> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    /**
     * Tìm kiếm khách hàng theo số điện thoại.
     * @param phone Số điện thoại của khách hàng.
     * @return Đối tượng Customer tìm thấy.
     */
    public Customer findByPhone(String phone) {
        return repo.findByPhone(phone);
    }

    /**
     * Tìm kiếm khách hàng theo email.
     * @param email Email của khách hàng.
     * @return Đối tượng Customer tìm thấy.
     */
    public Customer findByEmail(String email) {
        return repo.findByEmail(email);
    }

    /**
     * Lưu thông tin khách hàng vào cơ sở dữ liệu.
     * @param customer Đối tượng Customer cần lưu.
     */
    public void save(Customer customer) {
        repo.save(customer);
    }

    /**
     * Xóa khách hàng theo id.
     * @param cccd Id của khách hàng.
     */
    public void deleteById(String cccd) {
        repo.deleteById(cccd);
    }

    /**
     * Lấy các bản ghi cho trang hiện tại.
     * @param cccd Id của khách hàng.
     * @param startDate Ngày bắt đầu.
     * @param endDate Ngày kết thúc.
     * @param pageable Đối tượng Pageable chứa thông tin về số trang và số lượng bản ghi trên một trang.
     * @return Một trang chứa danh sách CustomerDTO.
     */
    public Page<CustomerDTO> getRecordsForCurrentPage(String cccd, LocalDate startDate, LocalDate endDate, Pageable pageable) {
        return repo.getRecordsForCurrentPage(cccd, startDate, endDate, pageable);
    }

    /**
     * Cập nhật thông tin khách hàng.
     * @param cccd Id của khách hàng.
     * @param phone Số điện thoại mới.
     * @param address Địa chỉ mới.
     * @param email Email mới.
     * @return Đối tượng Customer sau khi đã được cập nhật.
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
