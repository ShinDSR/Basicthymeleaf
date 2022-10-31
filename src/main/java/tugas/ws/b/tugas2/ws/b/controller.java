/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas.ws.b.tugas2.ws.b;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author fa506
 */
@Controller
public class controller {
    @RequestMapping(value="/view", method=RequestMethod.POST)
    //@ResponseBody
    public String getView(@RequestParam(value="inputNama") String nama,
                          @RequestParam(value="inputTanggal") Date tanggal,
                          @RequestParam(value="inputFoto") MultipartFile foto,
                          Model model)throws IOException{
        
        byte[] getFoto = foto.getBytes();
        String Image = Base64.encodeBase64String(getFoto);
        String getLink = "data:image/png;base64,".concat(Image);
        
        String getTanggal = "" + tanggal;
        
        model.addAttribute("attNama", nama);
        model.addAttribute("attTanggal", getTanggal);
        model.addAttribute("attFoto", getLink);
        return "main";
    }
}
