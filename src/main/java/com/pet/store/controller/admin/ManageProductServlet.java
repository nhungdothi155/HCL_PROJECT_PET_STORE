package com.pet.store.controller.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.google.inject.internal.util.Lists;
import com.pet.store.entity.Category;
import com.pet.store.entity.Product;
import com.pet.store.service.CategoryService;
import com.pet.store.service.ProductService;
import com.pet.store.service.impl.CategoryServiceImpl;
import com.pet.store.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class ManageProductServlet
 */
@WebServlet(urlPatterns = {"/admin/pets","/admin/pets/add","/admin/accessories/add", "/admin/accessories","/admin/products/insert"})
public class ManageProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductService productService;
    private CategoryService catService;
    //static for uploading file
    // location to store file uploaded
    private static final String UPLOAD_DIRECTORY = "uploads";
 
    // upload settings
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageProductServlet() {
    	productService =  new ProductServiceImpl();
    	catService = new CategoryServiceImpl();
       
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> products = productService.findAllProduct();
		List<Product> pets = products.stream().filter(p->p.getCategory().getCategoryName().equals("PET")).collect(Collectors.toList());
		List<Product> accessories = products.stream().filter(p->p.getCategory().getCategoryName().equals("ACCESSORIES")).collect(Collectors.toList());
		System.out.println(request);
		String action = request.getRequestURI();
		// list all pets
		if(action.endsWith("pets")) {
			System.out.println(pets.size());
			request.setAttribute("pets", pets);
			request.setAttribute("url", "pets");
			request.getRequestDispatcher("/admin/product.jsp").forward(request, response);
		}
		// list all accessories
		else if(action.endsWith("accessories")) {
			request.setAttribute("accessories", accessories);
			request.setAttribute("url", "accessories");
			request.getRequestDispatcher("/admin/product.jsp").forward(request, response);
		}
		// add form
		else if(action.endsWith("add")) {
			// for pet
			if(action.contains("pets")) {
				request.setAttribute("url", "pets");
			}
			// for accesories
			else {
				request.setAttribute("url", "accessories");
			}
			request.getRequestDispatcher("/admin/addAndUpdateProduct.jsp").forward(request, response);;
		}
		// insert function of product
		else if(action.endsWith("insert")) {
			// check if each element is null or not

		saveImageInUploadFolder(request, response);
		//System.out.println(saveImageInUploadFolder(request, response));
		
//		productService.insertProduct(p);
	    
	    	 //response.sendRedirect(request.getServletContext().getContextPath() +"/admin/accessories");
	    
	    response.sendRedirect(request.getServletContext().getContextPath() +"/admin/pets");
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public void saveImageInUploadFolder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getRequestURL());
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// Configure a repository (to ensure a secure temp location is used)
		ServletContext servletContext = this.getServletConfig().getServletContext();
		File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		factory.setRepository(repository);

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// Parse the request
		try {
			List<FileItem> items = upload.parseRequest(request);
			Iterator<FileItem> iter = items.iterator();
			// use for store information
			 Map<String,String> fields = new HashMap<>();
			    List<String> fileNames = new ArrayList<String>();
			while (iter.hasNext()) {
			    FileItem item = iter.next();
			    String filename="";
			   
			    if (item.isFormField()) {
			    	System.out.println(item.getFieldName()+ ":" + item.getString());
			    	fields.put(item.getFieldName(), item.getString());
			    } else {
			    	filename = item.getName();
			    	System.out.println(filename);
			      if(filename==null || filename.equals("")) {
			    	  break;
			      }
			      else {
			    	  Path path = Paths.get(filename);
			    	  String storePath = servletContext.getRealPath("/uploads");
			    	  File uploadFile = new File(storePath + "/" + path.getFileName());
			    	  File newFile =  createFileWithCurDate(uploadFile);
			    		  item.write(newFile);
			    	 
			    	System.out.println(newFile.getAbsolutePath());
			    	 fileNames.add(newFile.getAbsolutePath());
			      }
			    }
			}
			
			// after while
			long catId = Long.parseLong(fields.get("pCat"));
			String pName = fields.get("pName");
			String pDes = fields.get("pDes");
			String pOrigin = fields.get("pOrigin");
			float pPrice = Float.parseFloat(fields.get("pPrice"));
			int pNumbers = Integer.parseInt(fields.get("pNumbers"));
			double pWeight =Double.parseDouble( fields.get("pWeight"));
			double pAge =Double.parseDouble( fields.get("pAge"));
			
			Product p = new Product();
			Category c = catService.getCategoryById(catId);
			p.setCategory(c);
			p.setProductName(pName);
			p.setDescription(pDes);
			p.setOrigin(pOrigin);
			p.setPrice(pPrice);
			p.setProductNumbers(pNumbers);
			p.setWeight(pWeight);
			p.setAge(pAge);
			String[] photos = fileNames.toArray(new String[fileNames.size()] );
			p.setPhotos(String.join(",", photos));
			//insert product in the db;
			productService.insertProduct(p);

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }


    public File createFileWithCurDate(File from){
        String[] fileInfo = getFileInfo(from);
        String toPrefix=fileInfo[0]+generateSuffix();
        String toSuffix=fileInfo[1];
        return new File(from.getParent(),toPrefix+toSuffix);
    }
    public String[] getFileInfo(File from){
        String fileName=from.getName();
        int index = fileName.lastIndexOf(".");
        String toPrefix="";
        String toSuffix="";
        if(index==-1){
            toPrefix=fileName;
        }else{
            toPrefix=fileName.substring(0,index);
            toSuffix=fileName.substring(index,fileName.length());
        }
        return new String[]{toPrefix,toSuffix};
    }
	public  String generateSuffix() {
        // Get the current time
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        // Convert to string
        String formatDate = format.format(new Date());
        // Randomly generate file number
        int random = new Random().nextInt(10000);
        return new StringBuffer().append(formatDate).append(
                random).toString();
    }
    

}
