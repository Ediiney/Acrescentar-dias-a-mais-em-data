import com.sap.gateway.ip.core.customdev.util.Message;
import java.util.HashMap;
import groovy.json.*;
import java.text.SimpleDateFormat;    

def Message processData(Message message) {
    
    def header = message.getHeaders()
    String dataInicio = header.get('dataInicio')
    String dataFim = header.get('dataAlteracao')
    
    message.setProperty("dtInicio", dataInicio)
    message.setProperty("dtAlteracao", dataFim)
    
    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
    Calendar c = Calendar.getInstance();
    Calendar d = Calendar.getInstance();
    
    c.setTime(formato.parse(dataInicio));
    d.setTime(formato.parse(dataFim));
    
    c.add(Calendar.DATE, 15);  // número de dias a adicionar
    d.add(Calendar.DATE, 1);  // número de dias a adicionar
    
    dtInicio = formato.format(c.getTime());
    
    dtFim = formato.format(d.getTime());
    message.setProperty('dataInicio', dtInicio)
    message.setProperty('dataAlteracao', dtFim)
    return message;
}