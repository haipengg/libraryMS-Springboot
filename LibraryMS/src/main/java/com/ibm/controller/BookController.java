package com.ibm.controller;

import java.util.Date;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ibm.domain.Book;
import com.ibm.domain.BookLabel;
import com.ibm.domain.BorrowingDetails;
import com.ibm.domain.Country;
import com.ibm.domain.Theme;
import com.ibm.domain.Type;
import com.ibm.service.BookService;
import com.ibm.service.BorrowService;
import com.ibm.service.CountryService;
import com.ibm.service.ThemeService;
import com.ibm.service.TypeService;

/**
 * 
 * @author:刘志勇
 * @Description:图书模块
 */
@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private BorrowService borrowService;

	@Autowired
	private CountryService countryService;

	@Autowired
	private ThemeService themeService;

	@Autowired
	private TypeService typeService;

	/**
	 * @Description 获取图书信息列表
	 * @param pageNum：页数 pageSize：页面记录数
	 * @return 图书信息列表
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping("/list")
	public List<Book> selectBookList() {
		List<Book> books = bookService.selectAll();
		return books;
	}

	/**
	 * @Description 根据ID获取对应图书信息
	 * @param 图书ID
	 * @return 对应的图书信息
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping("/query")
	public Book selectBookById(Integer bookId) {
		return bookService.getById(bookId);
	}

	/**
	 * @Description 根据设置的标签获取对应图书信息
	 * @param bookLabel：图书关键字类 pageNum：页数 pageSize：页面记录数
	 * @return 对应的图书信息列表
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping("/list/label")
	public List<Book> selectBookListByLabel(@RequestBody BookLabel bookLabel) {
		List<Book> books = bookService.selectByLabel(bookLabel);
		return books;
	}

	/**
	 * @Description 根据关键字模糊查询对应图书信息
	 * @param 关键字
	 * @return 对应的图书信息列表
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping("/list/key")
	public List<Book> selectBookListByKey(String key) {
		List<Book> books = bookService.selectByKey(key);
		return books;
	}

	/**
	 * @Description 根据图书ID设置图书借阅记录列表
	 * @param 图书ID
	 * @return 更新好的图书信息类
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping("/borrows")
	public List<BorrowingDetails> selectBookBorrows(Integer id) {
		List<BorrowingDetails> bookBorrowingHistory = this.borrowService.selectBorrowsByUserId(id);
		return bookBorrowingHistory;
	}

	/**
	 * @Description 添加图书信息
	 * @param 新的图书信息
	 * @return 跳转到列表页面
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping("/add")
	public String addBook(@RequestBody Book book) {
		book.setOnTime(new Date());
		bookService.save(book);
		return "保存成功";
	}

	/**
	 * @Description 修改图书信息
	 * @param 更新后的图书信息
	 * @return 跳转到列表页面
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping("/update")
	public String updateBook(@RequestBody Book book) {
		if (book.getOffNumber() != 0) {
			book.setOffTime(new Date());
		}
		bookService.update(book);
		return "更新成功";
	}

	/**
	 * @Description 根据ID删除对应图书信息
	 * @param 图书ID
	 * @return 跳转到列表页面
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping("/delete")
	public String deleteBook(Integer bookId) {
		bookService.deleteById(bookId);
		return "删除成功";
	}

	/**
	 * @Description导入图书信息
	 * @param file
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping("/import")
	public String importUser(@RequestParam("file") MultipartFile file) {
		try {
			// 根据路径获取这个操作excel的实例
			XSSFWorkbook wb = new XSSFWorkbook(file.getInputStream()); // 根据页面index 获取sheet页
			XSSFSheet sheet = wb.getSheetAt(0);
			XSSFRow row = null;

			// 循环sesheet页中数据从第二行开始，第一行是标题
			for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {

				// 获取每一行数据
				row = sheet.getRow(i);

				Book book = new Book();

				book.setBookName(row.getCell(0).getStringCellValue());
				Country country = new Country();
				Integer countryId = countryService.getIdByName(row.getCell(1).getStringCellValue().trim());
				if (country == null || countryId == 0) {
					countryId = 9;
				}
				country.setCountryId(countryId);
				book.setCountry(country);
				Theme theme = new Theme();
				Integer themeId = themeService.getIdByName(row.getCell(2).getStringCellValue().trim());
				if (themeId == null || themeId == 0) {
					themeId = 10;
				}
				theme.setThemeId(themeId);
				book.setTheme(theme);
				Type type = new Type();
				Integer typeId = typeService.getIdByName(row.getCell(3).getStringCellValue().trim());
				if (typeId == null || typeId == 0) {
					typeId = 8;
				}
				type.setTypeId(typeId);
				book.setType(type);
				String page = row.getCell(4).getStringCellValue().trim();
				if (page.equals("短篇")) {
					book.setPages(1);
				} else if (page.equals("中篇")) {
					book.setPages(2);
				} else if (page.equals("长篇")) {
					book.setPages(3);
				} else if (page.equals("超长篇")) {
					book.setPages(4);
				} else {
					book.setPages(1);
				}
				book.setBrief(row.getCell(5).getStringCellValue().trim());
				book.setOnNumber(Integer.valueOf((int) row.getCell(6).getNumericCellValue()));
				book.setOnTime(new Date());
				book.setOffNumber(0);
				book.setSurplusNumber(Integer.valueOf((int) row.getCell(6).getNumericCellValue()));

				this.bookService.save(book);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "导入成功!";
	}

}
