package cafe_andino;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CafeteriaController {

    @GetMapping("/bienvenida")
    public String bienvenida() {
        return "Bienvenido a Café Andino";
    }

    @GetMapping("/pedido/{producto}")
    public String realizarPedido(@PathVariable String producto) {
        return "Preparando tu " + producto + "...";
    }

    @GetMapping("/menu")
    public Map<String, Integer> menu() {
        return Map.of(
                "tinto", 3000,
                "capuchino", 6500,
                "chocolate", 5500,
                "pan de bono", 2500);
    }

    @GetMapping("/cafeteria")
    public Map<String, Object> cafeteria() {
        return Map.of(
                "nombre", "Café Andino",
                "ciudad", "Bogotá",
                "abierto", true,
                "horario", "7:00 AM - 8:00 PM");
    }

    @GetMapping("/total/{precio}/{cantidad}")
    public String total(@PathVariable int precio, @PathVariable int cantidad) {
        return "Total a pagar: $" + (precio * cantidad);
    }

    @GetMapping("/descuento/{precio}/{porcentaje}")
    public String descuento(@PathVariable int precio, @PathVariable int porcentaje) {
        return "Precio final: $" + (precio - (precio * porcentaje / 100.0));
    }

    @GetMapping("/resumen/{producto}/{cantidad}")
    public Map<String, Object> resumen(@PathVariable String producto, @PathVariable int cantidad) {
        return Map.of(
                "producto", producto,
                "cantidad", cantidad,
                "mensaje", "Pedido confirmado");
    }
}
