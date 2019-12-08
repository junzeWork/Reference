package com.sjy.action;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sjy.bean.Books;
import com.sjy.mapper.BooksMapper;
import com.sjy.util.MyBatisHelper;

@Controller
public class BooksAction {

	@GetMapping("bookList.do")
	public String toBookList(@ModelAttribute List<Books> books,Model m) {
		m.addAttribute("books", books);
		return "bookList";
	}
	
	@GetMapping("toBookEdit")
	public String toBookEdit(Integer bookid,Model m) {
		if(null!=bookid) {
			SqlSession sess = MyBatisHelper.getSession();
			try {
				BooksMapper booksMapper = sess.getMapper(BooksMapper.class);
				m.addAttribute("book", booksMapper.selectByPrimaryKey(bookid));
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				sess.close();
			}
		}
		return "bookEdit";
	}
	
	@PostMapping("doSave")
	public String toBookEdit(Books book,
			@ModelAttribute List<Books> books,
			Model m,
			@RequestParam("image") MultipartFile file,
			HttpServletRequest request) {
		SqlSession sess = MyBatisHelper.getSession();
		try {
			// 文件上传
			String fn=file.getOriginalFilename();
			System.out.println(fn);
			String path="/images/"+fn; // web 路径转成磁盘路径
			if(fn!=null) {
				book.setBookimage(path);
				path=request.getServletContext().getRealPath(path);
				System.out.println(path);
				File fileObj=new File(path);
				file.transferTo(fileObj);
			}
			
			BooksMapper booksMapper = sess.getMapper(BooksMapper.class);
			if(null==book.getBookid()) {
				booksMapper.insertSelective(book);
			}else {
				booksMapper.updateByPrimaryKeySelective(book);
			}
			sess.commit();
		} catch (Exception e) {
			sess.rollback();
			e.printStackTrace();
		}finally {
			sess.close();
		}
		m.addAttribute("books", books);
		return "bookList";
	}
	
	@GetMapping("toBookShow")
	public String toBookShow(@ModelAttribute List<Books> books,Model m) {
		m.addAttribute("book", books.get(0));
		return "bookShow";
	}
	
	@GetMapping("toDelete")
	public String toDelete(Integer bookid,@ModelAttribute List<Books> books,Model m) {
		SqlSession sess = MyBatisHelper.getSession();
		try {
			BooksMapper booksMapper = sess.getMapper(BooksMapper.class);
			booksMapper.deleteByPrimaryKey(bookid);
			sess.commit();
		} catch (Exception e) {
			sess.rollback();
			e.printStackTrace();
		}finally {
			sess.close();
		}
		m.addAttribute("books", books);
		return "bookList";
	}
	
	@PostMapping("findByCondition.do")
	public String findByCondition(@ModelAttribute List<Books> books,Model m) {
		m.addAttribute("books", books);
		return "bookList";
	}
	
	@ModelAttribute
	public List<Books> findBook(Books book) {
		SqlSession sess = MyBatisHelper.getSession();
		System.out.println(book.getBookid()+"==");
		try {
			BooksMapper booksMapper = sess.getMapper(BooksMapper.class);
			List<Books> books= booksMapper.selectByCondition(book);
			return books;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sess.close();
		}
		return null;
	}
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
    }
}
